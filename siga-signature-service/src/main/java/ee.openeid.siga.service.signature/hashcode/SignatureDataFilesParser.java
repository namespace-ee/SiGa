package ee.openeid.siga.service.signature.hashcode;

import ee.openeid.siga.common.exception.DuplicateDataFileException;
import eu.europa.esig.dss.DigestAlgorithm;
import eu.europa.esig.dss.DomUtils;
import org.apache.commons.collections4.map.LinkedMap;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SignatureDataFilesParser {

    private byte[] signature;
    private LinkedMap<String, HashCodeDataFileEntry> entries = new LinkedMap<>();


    public SignatureDataFilesParser(byte[] signature) {
        this.signature = signature;
        loadDataFileEntries();
    }

    public Map<String, HashCodeDataFileEntry> getEntries() {
        return entries;
    }

    private void loadDataFileEntries() {
        Element root = DomUtils.buildDOM(signature).getDocumentElement();
        Node child = root.getFirstChild();
        addReferenceEntries(child);
        entries.remove(entries.lastKey());
    }

    private void addReferenceEntries(Node child) {
        while (child != null) {
            String nodeName = child.getLocalName();
            if ("Reference".equals(nodeName)) {
                addFileEntry(child);
            } else {
                addReferenceEntries(child.getFirstChild());
            }
            child = child.getNextSibling();
        }
    }

    private void addFileEntry(Node child) {
        NamedNodeMap attributes = child.getAttributes();
        HashCodeDataFileEntry entry = new HashCodeDataFileEntry();
        String fileName = URLDecoder.decode(attributes.getNamedItem("URI").getTextContent(), StandardCharsets.UTF_8);
        validateNotDuplicateFile(fileName);
        child = child.getFirstChild();

        while (child != null) {
            String nodeName = child.getLocalName();
            if ("DigestMethod".equals(nodeName)) {
                entry.setHashAlgo(getDigestAlgorithm(child));
            } else if ("DigestValue".equals(nodeName)) {
                String digest = child.getFirstChild().getNodeValue();
                entry.setHash(digest);
            }
            child = child.getNextSibling();
        }
        entries.put(fileName, entry);
    }

    private String getDigestAlgorithm(Node child) {
        NamedNodeMap digestMethodAttributes = child.getAttributes();
        String algorithm = digestMethodAttributes.getNamedItem("Algorithm").getTextContent();
        return DigestAlgorithm.forXML(algorithm).getName();
    }

    private void validateNotDuplicateFile(String filePath) {
        if (entries.containsKey(filePath))
            throw new DuplicateDataFileException("Unable to parse hashcodes datafile");
    }
}
