package ee.openeid.siga.test.helper;

public class TestData {

    // Endpoints
    public static final String HASHCODE_CONTAINERS = "/hashcodecontainers";
    public static final String CONTAINERS = "/containers";
    public static final String VALIDATIONREPORT = "/validationreport";
    public static final String UPLOAD = "/upload";
    public static final String REMOTE_SIGNING = "/remotesigning";
    public static final String MID_SIGNING = "/mobileidsigning";
    public static final String SMARTID_SIGNING = "/smartidsigning";
    public static final String STATUS = "/status";
    public static final String SIGNATURES = "/signatures";
    public static final String DATAFILES = "/datafiles";


    // Headers for HMAC authentication
    public static final String X_AUTHORIZATION_TIMESTAMP = "X-Authorization-Timestamp";
    public static final String X_AUTHORIZATION_SERVICE_UUID = "X-Authorization-ServiceUUID";
    public static final String X_AUTHORIZATION_SIGNATURE = "X-Authorization-Signature";
    public static final String X_AUTHORIZATION_HMAC_ALGO = "X-Authorization-Hmac-Algorithm";

    // User information
    public static final String SERVICE_UUID_1 = "a7fd7728-a3ea-4975-bfab-f240a67e894f";
    public static final String SERVICE_SECRET_1 = "746573745365637265744b6579303031";

    public static final String SERVICE_UUID_2 = "824dcfe9-5c26-4d76-829a-e6630f434746";
    public static final String SERVICE_SECRET_2 = "746573745365637265744b6579303032";

    public static final String SERVICE_UUID_3 = "400ff9a2-b5fb-4fde-b764-9b519963f82e";
    public static final String SERVICE_SECRET_3 = "746573745365637265744b6579303033";

    // Datafile mock strings
    public static final String DEFAULT_SHA256_DATAFILE = "RnKZobNWVy8u92sDL4S2j1BUzMT5qTgt6hm90TfAGRo=";
    public static final String DEFAULT_SHA512_DATAFILE = "hQVz9wirVZNvP/q3HoaW8nu0FfvrGkZinhADKE4Y4j/dUuGfgONfR4VYdu0p/dj/yGH0qlE0FGsmUB2N3oLuhA==";
    public static final String DEFAULT_FILENAME = "test.txt";
    public static final String DEFAULT_FILESIZE = "745";
    public static final String DEFAULT_DATAFILE_CONTENT = "cmFuZG9tdGV4dA==";
    public static final String DEFAULT_ASICE_CONTAINER_NAME = "valid.asice";
    public static final String DEFAULT_HASHCODE_CONTAINER_NAME = "hashcode.asice";
    public static final String DEFAULT_HASHCODE_CONTAINER = "UEsDBAoAAAgAACNhek6KIflFHwAAAB8AAAAIAAAAbWltZXR5cGVhcHBsaWNhdGlvbi92bmQuZXRzaS5hc2ljLWUremlwUEsDBBQACAgIACNhek4AAAAAAAAAAAAAAAAVAAAATUVUQS1JTkYvbWFuaWZlc3QueG1snZFLDsIwDESvUnmL0tIdiki74wRwgCg1YClxosatgNMTFvzEBth5RmO/kbzuT8FXM46ZIhto6yVUyC4OxAcDu+1GraDv1sEy7TGLvg9VWeP8kAamkXW0mbJmGzBrcTom5CG6KSCLfs/rG+jl7J48qhIbz9XTm7xXycrRQANPO+BAVsk5oQGbkidnpXRvZh5qlEx1KeEULi6UoPkeIUXXcpIvSNEJisoyog2/Ito/Gc3HB7orUEsHCDafv120AAAAuwEAAFBLAwQUAAgICAAjYXpOAAAAAAAAAAAAAAAAHQAAAE1FVEEtSU5GL2hhc2hjb2Rlcy1zaGEyNTYueG1sfc/NjoIwGIXhW2m+rUELqCkJ1QwqLEYmEeoYZ+dPEaSWkRYHevXqSlezPXmTJ8eftheBbrxWRSUp2H0MiMtDdSzkicKahRaB6cTPdyp/jFxN/KwQ3OJS1x3KGiGs353OKWiudF+3GtAzpZDIz59q/7X57kjjOWq+HKbO2Q7WJmajKzvpcX7xMMs+oqSigFRh+AMnHgz+A+x3IQ6T0E2Dv962LElwjGaLyIi4brvDjFzN3tzOqyZluCtJ/BIwdh33iQxej+5QSwcImEfmysUAAAADAQAAUEsDBBQACAgIACNhek4AAAAAAAAAAAAAAAAdAAAATUVUQS1JTkYvaGFzaGNvZGVzLXNoYTUxMi54bWx90E1vgjAAxvGvQno12vKSDRLQ6ICaSBw4wMnNrIXWQXkpMPHTT0/ztOuT/+GXx15dq1IZaSd5LRygLhBQqPiqCReFA5LYn5tgtbTZWbL7SOXSznlJ51T03aTkQ1nOm3PPHNBT2S/6aw+UR+oAFqU364d3abYfQ9jq2/p8NMWA/Hzs8HfGBVu7O884GRdIkgHnxfs+PxjpiQyogeQCJ7xFbekhH8sq2Wh7vQ4GtnYcoEh+o3eoaQH4H0Z91jRrzWUaPNZvQlxxYIUZmbkRHz+TqjVJhFUxRSe9Ybss3JUV3OZZ5mJz2rxaLMaabzSpFbTH2csHll7sWWQWRPJQPGkQ0jX9AYJ/T/0CUEsHCCG3/O8JAQAAWwEAAFBLAwQKAAAIAAAjYXpOGDZBl1c0AABXNAAAGAAAAE1FVEEtSU5GL3NpZ25hdHVyZXMwLnhtbDw/eG1sIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9IlVURi04IiBzdGFuZGFsb25lPSJubyI/Pjxhc2ljOlhBZEVTU2lnbmF0dXJlcyB4bWxuczphc2ljPSJodHRwOi8vdXJpLmV0c2kub3JnLzAyOTE4L3YxLjIuMSMiPjxkczpTaWduYXR1cmUgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiIElkPSJpZC1hOWZhZTAwNDk2YWUyMDNhNmE4YjkyYWRiZTc2MmJkMyI+PGRzOlNpZ25lZEluZm8+PGRzOkNhbm9uaWNhbGl6YXRpb25NZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiLz48ZHM6U2lnbmF0dXJlTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxkc2lnLW1vcmUjZWNkc2Etc2hhMjU2Ii8+PGRzOlJlZmVyZW5jZSBJZD0ici1pZC0xIiBVUkk9InRlc3QudHh0Ij48ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxlbmMjc2hhMjU2Ii8+PGRzOkRpZ2VzdFZhbHVlPlJuS1pvYk5XVnk4dTkyc0RMNFMyajFCVXpNVDVxVGd0NmhtOTBUZkFHUm89PC9kczpEaWdlc3RWYWx1ZT48L2RzOlJlZmVyZW5jZT48ZHM6UmVmZXJlbmNlIElkPSJyLWlkLTIiIFVSST0idGVzdDEudHh0Ij48ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxlbmMjc2hhMjU2Ii8+PGRzOkRpZ2VzdFZhbHVlPk1GUkYzU0J3K1lrazhCZEdDRUd6bE1yeHljQzhxemJ6dmpRdVNUMHlrOE09PC9kczpEaWdlc3RWYWx1ZT48L2RzOlJlZmVyZW5jZT48ZHM6UmVmZXJlbmNlIFR5cGU9Imh0dHA6Ly91cmkuZXRzaS5vcmcvMDE5MDMjU2lnbmVkUHJvcGVydGllcyIgVVJJPSIjeGFkZXMtaWQtYTlmYWUwMDQ5NmFlMjAzYTZhOGI5MmFkYmU3NjJiZDMiPjxkczpUcmFuc2Zvcm1zPjxkczpUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiLz48L2RzOlRyYW5zZm9ybXM+PGRzOkRpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZW5jI3NoYTI1NiIvPjxkczpEaWdlc3RWYWx1ZT50ZTRiSlh4Q0toRk1KQU5HRTRBVlc2d251bGxYSDBkbzVwMmwra2VQaldNPTwvZHM6RGlnZXN0VmFsdWU+PC9kczpSZWZlcmVuY2U+PC9kczpTaWduZWRJbmZvPjxkczpTaWduYXR1cmVWYWx1ZSBJZD0idmFsdWUtaWQtYTlmYWUwMDQ5NmFlMjAzYTZhOGI5MmFkYmU3NjJiZDMiPmNqcUlrUitNbTNna2FVZ0JtbExWbDNiTEk1ZWQ2WS9IZ2F2cDJLTFZvdkh4MFdlalhpOGdkL1p0SUFYMlJsd2Z2Q3VyVXRaaDJMd3pCRzFobWxrZk5DVlg2WThSQXlYVTFRZythcDFJSVI4Ti9LdzdvbTFDVk9Qbmwvc1AvdkZ0PC9kczpTaWduYXR1cmVWYWx1ZT48ZHM6S2V5SW5mbz48ZHM6WDUwOURhdGE+PGRzOlg1MDlDZXJ0aWZpY2F0ZT5NSUlENnpDQ0EwMmdBd0lCQWdJUVlTTXA3Q2hxMmJ0YnlHSTV1VzFucURBS0JnZ3Foa2pPUFFRREJEQmdNUXN3Q1FZRFZRUUdFd0pGUlRFYk1Ca0dBMVVFQ2d3U1Uwc2dTVVFnVTI5c2RYUnBiMjV6SUVGVE1SY3dGUVlEVlFSaERBNU9WRkpGUlMweE1EYzBOekF4TXpFYk1Ca0dBMVVFQXd3U1ZFVlRWQ0J2WmlCRlUxUkZTVVF5TURFNE1CNFhEVEU0TVRBeE9ERXdNelkwTVZvWERUSXpNVEF4TnpJeE5UazFPVm93ZnpFTE1Ba0dBMVVFQmhNQ1JVVXhLakFvQmdOVkJBTU1JVXJEbFVWUFVrY3NTa0ZCU3kxTFVrbFRWRXBCVGl3ek9EQXdNVEE0TlRjeE9ERVFNQTRHQTFVRUJBd0hTc09WUlU5U1J6RVdNQlFHQTFVRUtnd05Ta0ZCU3kxTFVrbFRWRXBCVGpFYU1CZ0dBMVVFQlJNUlVFNVBSVVV0TXpnd01ERXdPRFUzTVRnd2RqQVFCZ2NxaGtqT1BRSUJCZ1VyZ1FRQUlnTmlBQVRSWlRPcmcvSmVEOVdiRVRnU05KRUFBeUdDcFdMYkJWUExoQVhGTzRYOXh0SUZoblM1eklIZkpGNkRFQUN3Z0R5aHBwb1ZmN0U2S2NOeUVXRDRiUWYvLytIOVJjbzFHRFFoelYvaEYzODNSbUpFMnZGNTlEYzFMOGVGZ0ZKckJJK2pnZ0dyTUlJQnB6QUpCZ05WSFJNRUFqQUFNQTRHQTFVZER3RUIvd1FFQXdJR1FEQklCZ05WSFNBRVFUQS9NRElHQ3lzR0FRUUJnNUVoQVFJQk1DTXdJUVlJS3dZQkJRVUhBZ0VXRldoMGRIQnpPaTh2ZDNkM0xuTnJMbVZsTDBOUVV6QUpCZ2NFQUl2c1FBRUNNQjBHQTFVZERnUVdCQlNvdzdJc014QmJ0Z0ZJZzhCNmVuc0Q1b20raURDQmlnWUlLd1lCQlFVSEFRTUVmakI4TUFnR0JnUUFqa1lCQVRBSUJnWUVBSTVHQVFRd0V3WUdCQUNPUmdFR01Ba0dCd1FBamtZQkJnRXdVUVlHQkFDT1JnRUZNRWN3UlJZL2FIUjBjSE02THk5emF5NWxaUzlsYmk5eVpYQnZjMmwwYjNKNUwyTnZibVJwZEdsdmJuTXRabTl5TFhWelpTMXZaaTFqWlhKMGFXWnBZMkYwWlhNdkV3SkZUakFmQmdOVkhTTUVHREFXZ0JUQWhKa3B4RTZmT3dJMDlwbmhDbFlBQ0NrK2V6QnpCZ2dyQmdFRkJRY0JBUVJuTUdVd0xBWUlLd1lCQlFVSE1BR0dJR2gwZEhBNkx5OWhhV0V1WkdWdGJ5NXpheTVsWlM5bGMzUmxhV1F5TURFNE1EVUdDQ3NHQVFVRkJ6QUNoaWxvZEhSd09pOHZZeTV6YXk1bFpTOVVaWE4wWDI5bVgwVlRWRVZKUkRJd01UZ3VaR1Z5TG1OeWREQUtCZ2dxaGtqT1BRUURCQU9CaXdBd2dZY0NRUzBOb2h4ZC9ZRytINmNtYmw1dFJLQWZJTVk4UUk2WmtxVnFERjJiVUhabkxna3lTVW9lM014cU5VZmZvWmhkZDZhMU1ORGVFUGxOeDVES3NaNjJvNTk4QWtJQmZwT2lJbmllOENQTnRiekNFVDRsa3NhZm15dDFqcWRYS1NPQkd0aTU3Rkh6NnI1Y2dnTmV1enhScmtYVmtiL1lFYVVwTWtZdk5Db2tQUVZBdThWV0tTWT08L2RzOlg1MDlDZXJ0aWZpY2F0ZT48L2RzOlg1MDlEYXRhPjwvZHM6S2V5SW5mbz48ZHM6T2JqZWN0Pjx4YWRlczpRdWFsaWZ5aW5nUHJvcGVydGllcyB4bWxuczp4YWRlcz0iaHR0cDovL3VyaS5ldHNpLm9yZy8wMTkwMy92MS4zLjIjIiBUYXJnZXQ9IiNpZC1hOWZhZTAwNDk2YWUyMDNhNmE4YjkyYWRiZTc2MmJkMyI+PHhhZGVzOlNpZ25lZFByb3BlcnRpZXMgSWQ9InhhZGVzLWlkLWE5ZmFlMDA0OTZhZTIwM2E2YThiOTJhZGJlNzYyYmQzIj48eGFkZXM6U2lnbmVkU2lnbmF0dXJlUHJvcGVydGllcz48eGFkZXM6U2lnbmluZ1RpbWU+MjAxOS0wMi0yMlQxMTowNDoyNFo8L3hhZGVzOlNpZ25pbmdUaW1lPjx4YWRlczpTaWduaW5nQ2VydGlmaWNhdGU+PHhhZGVzOkNlcnQ+PHhhZGVzOkNlcnREaWdlc3Q+PGRzOkRpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZW5jI3NoYTI1NiIvPjxkczpEaWdlc3RWYWx1ZT56bXZtckd6SEY0aHc4eldJaXJwYjlTYm1oT3RSaW1PdUNNck9SRkZGNWlrPTwvZHM6RGlnZXN0VmFsdWU+PC94YWRlczpDZXJ0RGlnZXN0Pjx4YWRlczpJc3N1ZXJTZXJpYWw+PGRzOlg1MDlJc3N1ZXJOYW1lPkNOPVRFU1Qgb2YgRVNURUlEMjAxOCwyLjUuNC45Nz0jMGMwZTRlNTQ1MjQ1NDUyZDMxMzAzNzM0MzczMDMxMzMsTz1TSyBJRCBTb2x1dGlvbnMgQVMsQz1FRTwvZHM6WDUwOUlzc3Vlck5hbWU+PGRzOlg1MDlTZXJpYWxOdW1iZXI+MTI5MTE3Njk2MjcwMzM0MjM2NDYyOTUzNDI4MTIzNDU1OTQwNTIwPC9kczpYNTA5U2VyaWFsTnVtYmVyPjwveGFkZXM6SXNzdWVyU2VyaWFsPjwveGFkZXM6Q2VydD48L3hhZGVzOlNpZ25pbmdDZXJ0aWZpY2F0ZT48L3hhZGVzOlNpZ25lZFNpZ25hdHVyZVByb3BlcnRpZXM+PHhhZGVzOlNpZ25lZERhdGFPYmplY3RQcm9wZXJ0aWVzPjx4YWRlczpEYXRhT2JqZWN0Rm9ybWF0IE9iamVjdFJlZmVyZW5jZT0iI3ItaWQtMSI+PHhhZGVzOk1pbWVUeXBlPnRleHQvcGxhaW48L3hhZGVzOk1pbWVUeXBlPjwveGFkZXM6RGF0YU9iamVjdEZvcm1hdD48eGFkZXM6RGF0YU9iamVjdEZvcm1hdCBPYmplY3RSZWZlcmVuY2U9IiNyLWlkLTIiPjx4YWRlczpNaW1lVHlwZT50ZXh0L3BsYWluPC94YWRlczpNaW1lVHlwZT48L3hhZGVzOkRhdGFPYmplY3RGb3JtYXQ+PC94YWRlczpTaWduZWREYXRhT2JqZWN0UHJvcGVydGllcz48L3hhZGVzOlNpZ25lZFByb3BlcnRpZXM+PHhhZGVzOlVuc2lnbmVkUHJvcGVydGllcz48eGFkZXM6VW5zaWduZWRTaWduYXR1cmVQcm9wZXJ0aWVzPjx4YWRlczpTaWduYXR1cmVUaW1lU3RhbXAgSWQ9IlRTLWY4OGViZDdmLWFmZTAtNGJkZi1iZTI4LTRhMGE2YTNmMjllNCI+PGRzOkNhbm9uaWNhbGl6YXRpb25NZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiLz48eGFkZXM6RW5jYXBzdWxhdGVkVGltZVN0YW1wIElkPSJFVFMtZjg4ZWJkN2YtYWZlMC00YmRmLWJlMjgtNGEwYTZhM2YyOWU0Ij5NSUFHQ1NxR1NJYjNEUUVIQXFDQU1JSUh1Z0lCQXpFUE1BMEdDV0NHU0FGbEF3UUNBd1VBTUd3R0N5cUdTSWIzRFFFSkVBRUVvRjBFV3pCWkFnRUJCZ1lFQUk5bkFRRXdNVEFOQmdsZ2hrZ0JaUU1FQWdFRkFBUWd0TkNWL2RDUmt3Rk1SZm5MTi9DbHQxMHBpMDJFOVRUSEtYbWl6anJPVFNNQ0NCZnpYUWxlL1R6NkdBOHlNREU1TURJeU1qRXhNRFF5TlZxZ2dnUVpNSUlFRlRDQ0F2MmdBd0lCQWdJUVRxejdiQ1A4VzQ1VUJaYTd0enRUVERBTkJna3Foa2lHOXcwQkFRc0ZBREI5TVFzd0NRWURWUVFHRXdKRlJURWlNQ0FHQTFVRUNnd1pRVk1nVTJWeWRHbG1hWFJ6WldWeWFXMXBjMnRsYzJ0MWN6RXdNQzRHQTFVRUF3d25WRVZUVkNCdlppQkZSU0JEWlhKMGFXWnBZMkYwYVc5dUlFTmxiblJ5WlNCU2IyOTBJRU5CTVJnd0ZnWUpLb1pJaHZjTkFRa0JGZ2x3YTJsQWMyc3VaV1V3SGhjTk1UUXdPVEF5TVRBd05qVXhXaGNOTWpRd09UQXlNVEF3TmpVeFdqQmRNUXN3Q1FZRFZRUUdFd0pGUlRFaU1DQUdBMVVFQ2d3WlFWTWdVMlZ5ZEdsbWFYUnpaV1Z5YVcxcGMydGxjMnQxY3pFTU1Bb0dBMVVFQ3d3RFZGTkJNUnd3R2dZRFZRUUREQk5FUlUxUElHOW1JRk5MSUZSVFFTQXlNREUwTUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUF5c2dyVm5WUHhIOGpOZ0NzSncweSs3Zm1tQkRUTS90TkIreGllbG5QOUtjdVErbnlUZ051MUpNcG5yeTdSaDRuZHI1NHJQTFhOR1ZkYi92c2dzaThCNTU4RGlzUFZVbjNSdXIzLzhYUStCQ2toVFFJZzFjU215Q3NXeEpnZWFRS0ppNldHVmFRV0IyaGUzNWFWaEw1RjZhZS9nelhUM3NHR3duV3VqWmtZOW81UmFwR1YxNSsvYjdVdis3aldZRkF4Y0Q2YmE1akkwMFJZL2dtc1d3S2IyMjZSbnovcFhLREJmdU4zb3g3eTUvbFpmNStNeUljVmUxcUplN1ZBSkdwSkZqTnErQkVFZHZmcXZKMVBpR1FFREpBUGhScWFoVmpCU3pxWmhKUW9MM0hJNDJOUkNGd2FydmRuWllvQ1B4amVZcEF5blRIZ05SN2tLR1gxaVE4T1FJREFRQUJvNEd3TUlHdE1BNEdBMVVkRHdFQi93UUVBd0lHd0RBV0JnTlZIU1VCQWY4RUREQUtCZ2dyQmdFRkJRY0RDREFkQmdOVkhRNEVGZ1FVSndTY1pReHpsenlTVnFaWHZpWHBLWkRWNU53d0h3WURWUjBqQkJnd0ZvQVV0VFFLbmFVdkVNWG5JUTYreExGbFJ4c0RkdjR3UXdZRFZSMGZCRHd3T2pBNG9EYWdOSVl5YUhSMGNITTZMeTkzZDNjdWMyc3VaV1V2Y21Wd2IzTnBkRzl5ZVM5amNteHpMM1JsYzNSZlpXVmpZM0pqWVM1amNtd3dEUVlKS29aSWh2Y05BUUVMQlFBRGdnRUJBSXEwMlNWS3dQMVVvbEtqcUFRZTdTVlkvS2dpKytHMmtxQWQ0MFVtTXFhOTRHVHU5MUxGWlI1VHZkb3laampuUTJpb1hoNUNWMmxmbFV5L2xVclpNRHBxRWU3SWJqWlc1K2I5bjVhQnZYWUpnRHVhOVNZak1PcmN5M3NpeXRxcThVYk5naDc5dWJZZ1doSGhKU25MV0s1WUorNXZRalRwT01kUnNMcC9EK0ZoVFVhNm1QMFVEWStVODIvdEZ1ZmtkOUhXNHpiYWxVV2hRZ25OWUkzb28wQ3NaMEhFeHV5bk9PWm1NMUJmOFB6RDZldGxMU0trWUIrbUI3N09tcWdmbHp6K0pqeWg0NW8rMzA1TVJ6SERGZUpaeDdXeEMrWFROV1EwWkZURmZjMG96eHh6VVdVbGZOZnBXeVFoMys0TGJlU1FSV3JOa2JOUmZDcFlvdHlNNkFZeGdnTVhNSUlERXdJQkFUQ0JrVEI5TVFzd0NRWURWUVFHRXdKRlJURWlNQ0FHQTFVRUNnd1pRVk1nVTJWeWRHbG1hWFJ6WldWeWFXMXBjMnRsYzJ0MWN6RXdNQzRHQTFVRUF3d25WRVZUVkNCdlppQkZSU0JEWlhKMGFXWnBZMkYwYVc5dUlFTmxiblJ5WlNCU2IyOTBJRU5CTVJnd0ZnWUpLb1pJaHZjTkFRa0JGZ2x3YTJsQWMyc3VaV1VDRUU2cysyd2ovRnVPVkFXV3U3YzdVMHd3RFFZSllJWklBV1VEQkFJREJRQ2dnZ0ZXTUJvR0NTcUdTSWIzRFFFSkF6RU5CZ3NxaGtpRzl3MEJDUkFCQkRBY0Jna3Foa2lHOXcwQkNRVXhEeGNOTVRrd01qSXlNVEV3TkRJMVdqQlBCZ2txaGtpRzl3MEJDUVF4UWdSQXdFaldKR1c3MnlzS3BnYVk1dmdqVmdtMWpVaUx5UXJuSnUwTittWGRNSW4xRnlUbktmNWx6L05zb1E0dHZ5L3J5QWNPL1B1NUh3QnozN0F3dDJBY2h6Q0J5QVlMS29aSWh2Y05BUWtRQWd3eGdiZ3dnYlV3Z2JJd2dhOEVGQUt4bCs5NHJ1Rng5cUZIWDFEcXpHVng4ZndMTUlHV01JR0JwSDh3ZlRFTE1Ba0dBMVVFQmhNQ1JVVXhJakFnQmdOVkJBb01HVUZUSUZObGNuUnBabWwwYzJWbGNtbHRhWE5yWlhOcmRYTXhNREF1QmdOVkJBTU1KMVJGVTFRZ2IyWWdSVVVnUTJWeWRHbG1hV05oZEdsdmJpQkRaVzUwY21VZ1VtOXZkQ0JEUVRFWU1CWUdDU3FHU0liM0RRRUpBUllKY0d0cFFITnJMbVZsQWhCT3JQdHNJL3hiamxRRmxydTNPMU5NTUEwR0NTcUdTSWIzRFFFQkFRVUFCSUlCQUI1ZVhMTFZWNFREcVFMTUxaelFOL2QwcnQxdDQxVWp5Mk9wa0k0TGhFUmVTU0dtZW5NbGRhM0N5SDZFeU84TFBWV3ZuWmFXcFdZUmxPclZKNE1SMlIwS05xc08vTnFOZzF5WVNrTlZKTkRQUWpKeHpvMHdSSDJLdUhQVVhqTm9obCtHTk9kTGJ5dG43dVUrWGRPQVpsUHI2UUJxVnIwUC9IY0dqeVM3QUZucnFsNUlnL092R2JMWXB5VGE3eVVrOEpoNGpaNHczNE00cHl6OVpYVkJpdnVIekJ4eThubzQ1OGsvdnlsdFJLak50MGRMUW9MaUZuUW8wekJwbGROcytxWWZNUTJ1UXRFZjZpcURhOHJ6VkhBSWhYaXhNZEtYalZxZzdMSHdNdHk3LzY1NE91aGtFY2hEdWNnTG9uMmJmeHlCTnZ6VWNtcVY5NWVnZHBPM054UUFBQUFBPC94YWRlczpFbmNhcHN1bGF0ZWRUaW1lU3RhbXA+PC94YWRlczpTaWduYXR1cmVUaW1lU3RhbXA+PHhhZGVzOkNlcnRpZmljYXRlVmFsdWVzPjx4YWRlczpFbmNhcHN1bGF0ZWRYNTA5Q2VydGlmaWNhdGUgSWQ9ImlkLWE5ZmFlMDA0OTZhZTIwM2E2YThiOTJhZGJlNzYyYmQzLVJFU1BPTkRFUl9DRVJULTAiPk1JSUVpakNDQTNLZ0F3SUJBZ0lRYUk4eDZCbmFjWWROZE53bFlubi9tekFOQmdrcWhraUc5dzBCQVFVRkFEQjlNUXN3Q1FZRFZRUUdFd0pGUlRFaU1DQUdBMVVFQ2d3WlFWTWdVMlZ5ZEdsbWFYUnpaV1Z5YVcxcGMydGxjMnQxY3pFd01DNEdBMVVFQXd3blZFVlRWQ0J2WmlCRlJTQkRaWEowYVdacFkyRjBhVzl1SUVObGJuUnlaU0JTYjI5MElFTkJNUmd3RmdZSktvWklodmNOQVFrQkZnbHdhMmxBYzJzdVpXVXdIaGNOTVRFd016QTNNVE15TWpRMVdoY05NalF3T1RBM01USXlNalExV2pDQmd6RUxNQWtHQTFVRUJoTUNSVVV4SWpBZ0JnTlZCQW9NR1VGVElGTmxjblJwWm1sMGMyVmxjbWx0YVhOclpYTnJkWE14RFRBTEJnTlZCQXNNQkU5RFUxQXhKekFsQmdOVkJBTU1IbFJGVTFRZ2IyWWdVMHNnVDBOVFVDQlNSVk5RVDA1RVJWSWdNakF4TVRFWU1CWUdDU3FHU0liM0RRRUpBUllKY0d0cFFITnJMbVZsTUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUEwY3c2Q2phMTdCYlliSGk2ZnJ3Y2NESTRCSVFMay9maUNFOEw0NW9zMHhoUGdFR1IrRUhFOExQQ0lxb2ZQZ2Y0Z3dOMXZERTZjUU5VbEswT2QrVXNoMzlpOVo0NWVzbmZwR3ErMkhzREphRm1GcjUrdUMxTUV6NUtuMVRhekV2S2JSamtHblNROUJlcnRsR2VyMkJsVS9rcU9rNXFBNVJ0SmZoVDBwc2MxaXhLZFBpcHY1OXduZituSHgxK1QrZlBXbmRYVlpMb0RnNHQzdzhsSXZJRS9LaE9TTWxFcnZCSUhJQUtWN3lIMWhPeHllR0xnaHF6TWlBbjNVZVRFT2dvT1M5VVJ2MEMvVDVDM21IK1kvdWFrTVN4ak51ejQxUG5laW1DemJFSlpKUmlFYU1JajhxUEF1YmNiTDhHdFkwM01XbWZOdFg2L3doNnU2VE1mVzhTMndJREFRQUJvNEgrTUlIN01CWUdBMVVkSlFFQi93UU1NQW9HQ0NzR0FRVUZCd01KTUIwR0ExVWREZ1FXQkJSOS81Q3VSb2tFZ0dpcVN6WXVaR1lBb2dsOFR6Q0JvQVlEVlIwZ0JJR1lNSUdWTUlHU0Jnb3JCZ0VFQWM0ZkF3RUJNSUdETUZnR0NDc0dBUVVGQndJQ01Fd2VTZ0JCQUdrQWJnQjFBR3dBZEFBZ0FIUUFaUUJ6QUhRQWFRQnRBR2tBY3dCbEFHc0Fjd0F1QUNBQVR3QnVBR3dBZVFBZ0FHWUFid0J5QUNBQWRBQmxBSE1BZEFCcEFHNEFad0F1TUNjR0NDc0dBUVVGQndJQkZodG9kSFJ3T2k4dmQzZDNMbk5yTG1WbEwyRnFZWFJsYlhCbGJDOHdId1lEVlIwakJCZ3dGb0FVdFRRS25hVXZFTVhuSVE2K3hMRmxSeHNEZHY0d0RRWUpLb1pJaHZjTkFRRUZCUUFEZ2dFQkFBYmFqN2tUcnVUQVBIcVRveWU5WnRCZGFKM0ZaamlLdWc5LzVSanNNd0RwT2VxRkRxQ29yTGQrREJJNHRnZHUwZzRsaGFJM2FWbktkUkJrR1YxOGtxcDg0dVU5N0pSRldRRWY2SDhocEo5ay9MekFBQ2tQM3REKzB5bSttZDUzMm1WK25SejFKaitSUExBVWs5eFlNVjdLUGN6Wk4xeG5sMndaREp3QmJRcGNTVkgxRGpsWnYzdEZMSEJMSVlUUzZxT0s0U3hTdGNnUnE3S2RSY3pmVzZtZlh6VENSV00zRzlubURlaTVRMytYVEVENDFqOHN6UldnbHpZZjZ6T3Y0ZGpramE2NFdZcmFRNXpiNHg4WGg3cVRDazZVdXBaN2plKzBvUmZ1ejBoLzN6eVJkamNSUGtqbG9TcFFwL05HOFJtcmNucjg3NHA4ZDlmZHdDclJJN1U9PC94YWRlczpFbmNhcHN1bGF0ZWRYNTA5Q2VydGlmaWNhdGU+PHhhZGVzOkVuY2Fwc3VsYXRlZFg1MDlDZXJ0aWZpY2F0ZT5NSUlGZkRDQ0JOMmdBd0lCQWdJUU5oanpTZmQyVUVwYmtPMTRFWTRPUlRBS0JnZ3Foa2pPUFFRREJEQmlNUXN3Q1FZRFZRUUdFd0pGUlRFYk1Ca0dBMVVFQ2d3U1Uwc2dTVVFnVTI5c2RYUnBiMjV6SUVGVE1SY3dGUVlEVlFSaERBNU9WRkpGUlMweE1EYzBOekF4TXpFZE1Cc0dBMVVFQXd3VVZFVlRWQ0J2WmlCRlJTMUhiM1pEUVRJd01UZ3dIaGNOTVRnd09UQTJNRGt3TXpVeVdoY05Nek13T0RNd01USTBPREk0V2pCZ01Rc3dDUVlEVlFRR0V3SkZSVEViTUJrR0ExVUVDZ3dTVTBzZ1NVUWdVMjlzZFhScGIyNXpJRUZUTVJjd0ZRWURWUVJoREE1T1ZGSkZSUzB4TURjME56QXhNekViTUJrR0ExVUVBd3dTVkVWVFZDQnZaaUJGVTFSRlNVUXlNREU0TUlHYk1CQUdCeXFHU000OUFnRUdCU3VCQkFBakE0R0dBQVFCeFl1ZzRjRXF3bUlqKzNUVmFVbGhmeENWOUZRZ2Z1Z2xDMi8wVXgxSWVxdzExbURqTnZuR0poa1d4YUxiV0ppN1F0dGhNRzVSMTA0bDdOcDdsQmV2ckJnQkR0ZmdqYTllM01MVFFrWStjRlMrVVF4anQ5WmloVFVKVnNSN2xvd1lsYUdFaXFxc0diRWhsd2Z1MjdYc204YjJyaFNpVE92TmRqVHRHNTdObndWQVgraWpnZ015TUlJRExqQWZCZ05WSFNNRUdEQVdnQlIvREhEWTlPV1BBWGZ1eDIwcEtibjB5Znhxd0RBZEJnTlZIUTRFRmdRVXdJU1pLY1JPbnpzQ05QYVo0UXBXQUFncFBuc3dEZ1lEVlIwUEFRSC9CQVFEQWdFR01CSUdBMVVkRXdFQi93UUlNQVlCQWY4Q0FRQXdnZ0hOQmdOVkhTQUVnZ0hFTUlJQndEQUlCZ1lFQUk5NkFRSXdDUVlIQkFDTDdFQUJBakF5QmdzckJnRUVBWU9SSVFFQ0FUQWpNQ0VHQ0NzR0FRVUZCd0lCRmhWb2RIUndjem92TDNkM2R5NXpheTVsWlM5RFVGTXdEUVlMS3dZQkJBR0RrU0VCQWdJd0RRWUxLd1lCQkFHRGtYOEJBZ0V3RFFZTEt3WUJCQUdEa1NFQkFnVXdEUVlMS3dZQkJBR0RrU0VCQWdZd0RRWUxLd1lCQkFHRGtTRUJBZ2N3RFFZTEt3WUJCQUdEa1NFQkFnTXdEUVlMS3dZQkJBR0RrU0VCQWdRd0RRWUxLd1lCQkFHRGtTRUJBZ2d3RFFZTEt3WUJCQUdEa1NFQkFna3dEUVlMS3dZQkJBR0RrU0VCQWdvd0RRWUxLd1lCQkFHRGtTRUJBZ3N3RFFZTEt3WUJCQUdEa1NFQkFnd3dEUVlMS3dZQkJBR0RrU0VCQWcwd0RRWUxLd1lCQkFHRGtTRUJBZzR3RFFZTEt3WUJCQUdEa1NFQkFnOHdEUVlMS3dZQkJBR0RrU0VCQWhBd0RRWUxLd1lCQkFHRGtTRUJBaEV3RFFZTEt3WUJCQUdEa1NFQkFoSXdEUVlMS3dZQkJBR0RrU0VCQWhNd0RRWUxLd1lCQkFHRGtTRUJBaFF3RFFZTEt3WUJCQUdEa1g4QkFnSXdEUVlMS3dZQkJBR0RrWDhCQWdNd0RRWUxLd1lCQkFHRGtYOEJBZ1F3RFFZTEt3WUJCQUdEa1g4QkFnVXdEUVlMS3dZQkJBR0RrWDhCQWdZd0tnWURWUjBsQVFIL0JDQXdIZ1lJS3dZQkJRVUhBd2tHQ0NzR0FRVUZCd01DQmdnckJnRUZCUWNEQkRCM0JnZ3JCZ0VGQlFjQkFRUnJNR2t3TGdZSUt3WUJCUVVITUFHR0ltaDBkSEE2THk5aGFXRXVaR1Z0Ynk1emF5NWxaUzlsWlMxbmIzWmpZVEl3TVRnd053WUlLd1lCQlFVSE1BS0dLMmgwZEhBNkx5OWpMbk5yTG1WbEwxUmxjM1JmYjJaZlJVVXRSMjkyUTBFeU1ERTRMbVJsY2k1amNuUXdHQVlJS3dZQkJRVUhBUU1FRERBS01BZ0dCZ1FBamtZQkFUQTRCZ05WSFI4RU1UQXZNQzJnSzZBcGhpZG9kSFJ3T2k4dll5NXpheTVsWlM5VVpYTjBYMjltWDBWRkxVZHZka05CTWpBeE9DNWpjbXd3Q2dZSUtvWkl6ajBFQXdRRGdZd0FNSUdJQWtJQklGK0xxeXR5YVY0bzV3VVNtMzBWeXNCOExkV3RvT3J6TnEyUWhCNnRHdjRzbGc1eitDUjU4ZTYwZVJGcU54VDdlY2NBL0hnb1BXczBCMVorTDA2N3F0VUNRZ0NCOE9QMGtIeC9qMXQ3aHROMkNYanBTakdGWnc1VFRJNHMxZUd5VGJlMFVKUkJYRWtVS2ZGYlpWbXpHUEZQcHJ3VWRTUGk4UHBPNyt4R0JZbEZIQTR6K1E9PTwveGFkZXM6RW5jYXBzdWxhdGVkWDUwOUNlcnRpZmljYXRlPjwveGFkZXM6Q2VydGlmaWNhdGVWYWx1ZXM+PHhhZGVzOlJldm9jYXRpb25WYWx1ZXM+PHhhZGVzOk9DU1BWYWx1ZXM+PHhhZGVzOkVuY2Fwc3VsYXRlZE9DU1BWYWx1ZT5NSUlHK3dvQkFLQ0NCdlF3Z2did0Jna3JCZ0VGQlFjd0FRRUVnZ2JoTUlJRzNUQ0NBUytoZ1lZd2dZTXhDekFKQmdOVkJBWVRBa1ZGTVNJd0lBWURWUVFLREJsQlV5QlRaWEowYVdacGRITmxaWEpwYldsemEyVnphM1Z6TVEwd0N3WURWUVFMREFSUFExTlFNU2N3SlFZRFZRUUREQjVVUlZOVUlHOW1JRk5MSUU5RFUxQWdVa1ZUVUU5T1JFVlNJREl3TVRFeEdEQVdCZ2txaGtpRzl3MEJDUUVXQ1hCcmFVQnpheTVsWlJnUE1qQXhPVEF5TWpJeE1UQTBNamRhTUdBd1hqQkpNQWtHQlNzT0F3SWFCUUFFRkRLWFFwS2NadlZYQzgvVEpJNVVpTmJScnF1ckJCVEFoSmtweEU2Zk93STA5cG5oQ2xZQUNDaytld0lRWVNNcDdDaHEyYnRieUdJNXVXMW5xSUFBR0E4eU1ERTVNREl5TWpFeE1EUXlOMXFoTVRBdk1DMEdDU3NHQVFVRkJ6QUJBZ1FnRVJPN0dGcEZqRXRvemlWd0tDNzMxQ0YvUWIrNGMyMW1EV1VLcDU1cFNROHdEUVlKS29aSWh2Y05BUUVMQlFBRGdnRUJBSzltR09zbW5SNVhOaHZxYWxXM3crZjU3L2x1TFZtNi9UWnhBc1g0MDJJMVZSQTMwVUtmZ1JNTEJraFViMVpoM3AzM2hOc1l5cXFTUmNYdU1MU0VPU09jeHZBNzVNdFhQMkRrNTJXZDR0eFVyWGh3dE1wd0J0VzJWYzgrOGxEemZnQ1crbllKS0JxeWFNL2tMQlFYTE1ZdzRDOW0rak5iV2JOSVY4MU9MQUFsL3dKWEt4YXYrQndjeUxiNmRtSzU2ZlA3TGk4WEsyUk9mQzJRNkRnK05QcHBnb1ZaczdoUVBFbmJHbENtZ0V0amRIRElBMElSSXcvRGNDa3M1T1VNbWtLSFhpbGNNV0R5OVpobFJmSCtBNlk0NS9oOHpPN0ZPa3JYQmM3RW9BS1ptS3pNNCtDZGpFRHRObkFNTGU0TmJ5OGl1NVNjR0RVZWFvbE11NU5ZTnV5Z2dnU1NNSUlFampDQ0JJb3dnZ055b0FNQ0FRSUNFR2lQTWVnWjJuR0hUWFRjSldKNS81c3dEUVlKS29aSWh2Y05BUUVGQlFBd2ZURUxNQWtHQTFVRUJoTUNSVVV4SWpBZ0JnTlZCQW9NR1VGVElGTmxjblJwWm1sMGMyVmxjbWx0YVhOclpYTnJkWE14TURBdUJnTlZCQU1NSjFSRlUxUWdiMllnUlVVZ1EyVnlkR2xtYVdOaGRHbHZiaUJEWlc1MGNtVWdVbTl2ZENCRFFURVlNQllHQ1NxR1NJYjNEUUVKQVJZSmNHdHBRSE5yTG1WbE1CNFhEVEV4TURNd056RXpNakkwTlZvWERUSTBNRGt3TnpFeU1qSTBOVm93Z1lNeEN6QUpCZ05WQkFZVEFrVkZNU0l3SUFZRFZRUUtEQmxCVXlCVFpYSjBhV1pwZEhObFpYSnBiV2x6YTJWemEzVnpNUTB3Q3dZRFZRUUxEQVJQUTFOUU1TY3dKUVlEVlFRRERCNVVSVk5VSUc5bUlGTkxJRTlEVTFBZ1VrVlRVRTlPUkVWU0lESXdNVEV4R0RBV0Jna3Foa2lHOXcwQkNRRVdDWEJyYVVCemF5NWxaVENDQVNJd0RRWUpLb1pJaHZjTkFRRUJCUUFEZ2dFUEFEQ0NBUW9DZ2dFQkFOSE1PZ28ydGV3VzJHeDR1bjY4SEhBeU9BU0VDNVAzNGdoUEMrT2FMTk1ZVDRCQmtmaEJ4UEN6d2lLcUh6NEgrSU1EZGJ3eE9uRURWSlN0RG5mbExJZC9ZdldlT1hySjM2UnF2dGg3QXlXaFpoYStmcmd0VEJNK1NwOVUyc3hMeW0wWTVCcDBrUFFYcTdaUm5xOWdaVlA1S2pwT2FnT1ViU1g0VTlLYkhOWXNTblQ0cWIrZmNKMy9weDhkZmsvbnoxcDNWMVdTNkE0T0xkOFBKU0x5QlB5b1RrakpSSzd3U0J5QUNsZThoOVlUc2NuaGk0SWFzeklnSjkxSGt4RG9LRGt2VkViOUF2MCtRdDVoL21QN21wREVzWXpicytOVDUzb3BnczJ4Q1dTVVloR2pDSS9LandMbTNHeS9CcldOTnpGcG56YlYrdjhJZXJ1a3pIMXZFdHNDQXdFQUFhT0IvakNCK3pBV0JnTlZIU1VCQWY4RUREQUtCZ2dyQmdFRkJRY0RDVEFkQmdOVkhRNEVGZ1FVZmYrUXJrYUpCSUJvcWtzMkxtUm1BS0lKZkU4d2dhQUdBMVVkSUFTQm1EQ0JsVENCa2dZS0t3WUJCQUhPSHdNQkFUQ0JnekJZQmdnckJnRUZCUWNDQWpCTUhrb0FRUUJwQUc0QWRRQnNBSFFBSUFCMEFHVUFjd0IwQUdrQWJRQnBBSE1BWlFCckFITUFMZ0FnQUU4QWJnQnNBSGtBSUFCbUFHOEFjZ0FnQUhRQVpRQnpBSFFBYVFCdUFHY0FMakFuQmdnckJnRUZCUWNDQVJZYmFIUjBjRG92TDNkM2R5NXpheTVsWlM5aGFtRjBaVzF3Wld3dk1COEdBMVVkSXdRWU1CYUFGTFUwQ3AybEx4REY1eUVPdnNTeFpVY2JBM2IrTUEwR0NTcUdTSWIzRFFFQkJRVUFBNElCQVFBRzJvKzVFNjdrd0R4Nms2TW52V2JRWFdpZHhXWTRpcm9QZitVWTdETUE2VG5xaFE2Z3FLeTNmZ3dTT0xZSGJ0SU9KWVdpTjJsWnluVVFaQmxkZkpLcWZPTGxQZXlVUlZrQkgraC9JYVNmWlB5OHdBQXBEOTdRL3RNcHZwbmVkOXBsZnAwYzlTWS9rVHl3RkpQY1dERmV5ajNNMlRkY1o1ZHNHUXljQVcwS1hFbFI5UTQ1V2I5N1JTeHdTeUdFMHVxaml1RXNVclhJRWF1eW5VWE0zMXVwbjE4MHdrVmpOeHZaNWczb3VVTi9sMHhBK05ZL0xNMFZvSmMySCtzenIrSFk1STJ1dUZtSzJrT2MyK01mRjRlNmt3cE9sTHFXZTQzdnRLRVg3czlJZjk4OGtYWTNFVDVJNWFFcVVLZnpSdkVacTNKNi9PK0tmSGZYM2NBcTBTTzE8L3hhZGVzOkVuY2Fwc3VsYXRlZE9DU1BWYWx1ZT48L3hhZGVzOk9DU1BWYWx1ZXM+PC94YWRlczpSZXZvY2F0aW9uVmFsdWVzPjwveGFkZXM6VW5zaWduZWRTaWduYXR1cmVQcm9wZXJ0aWVzPjwveGFkZXM6VW5zaWduZWRQcm9wZXJ0aWVzPjwveGFkZXM6UXVhbGlmeWluZ1Byb3BlcnRpZXM+PC9kczpPYmplY3Q+PC9kczpTaWduYXR1cmU+PC9hc2ljOlhBZEVTU2lnbmF0dXJlcz5QSwECCgAKAAAIAAAjYXpOiiH5RR8AAAAfAAAACAAAAAAAAAAAAAAAAAAAAAAAbWltZXR5cGVQSwECFAAUAAgICAAjYXpONp+/XbQAAAC7AQAAFQAAAAAAAAAAAAAAAABFAAAATUVUQS1JTkYvbWFuaWZlc3QueG1sUEsBAhQAFAAICAgAI2F6TphH5srFAAAAAwEAAB0AAAAAAAAAAAAAAAAAPAEAAE1FVEEtSU5GL2hhc2hjb2Rlcy1zaGEyNTYueG1sUEsBAhQAFAAICAgAI2F6TiG3/O8JAQAAWwEAAB0AAAAAAAAAAAAAAAAATAIAAE1FVEEtSU5GL2hhc2hjb2Rlcy1zaGE1MTIueG1sUEsBAgoACgAACAAAI2F6Thg2QZdXNAAAVzQAABgAAAAAAAAAAAAAAAAAoAMAAE1FVEEtSU5GL3NpZ25hdHVyZXMwLnhtbFBLBQYAAAAABQAFAFUBAAAtOAAAAAA=";
    public static final String HASHCODE_CONTAINER_WITH_LTA_SIGNATURE = "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aEcWvKnjay61mMxWc//oX3CZupifNwnf+9mxdOSOywt+x0vyUHOyiM0tnQ6SYbV2YkIpICM/rBUHI8A/IP4LUbfzBVBLAQIKAAoAAAgAAG5e406KIflFHwAAAB8AAAAIAAAA4wAAAAAAAAAAAAAAAABtaW1ldHlwZUxJQiBEaWdpRG9jNGovREVWIGZvcm1hdDogYXBwbGljYXRpb24vdm5kLmV0c2kuYXNpYy1lK3ppcCBzaWduYXR1cmVQcm9maWxlOiBYQWRFU19CQVNFTElORV9MVEEgSmF2YTogMS44LjBfMjAyLWVhL09yYWNsZSBDb3Jwb3JhdGlvbiBPUzogV2luZG93cyAxMC9hbWQ2NC8xMC4wIEpWTTogSmF2YSBIb3RTcG90KFRNKSA2NC1CaXQgU2VydmVyIFZNL09yYWNsZSBDb3Jwb3JhdGlvbi8yNS4yMDItYjAzUEsBAhQAFAAICAgAbl7jThPS4LWyAAAAWAEAABUAAADjAAAAAAAAAAAARQAAAE1FVEEtSU5GL21hbmlmZXN0LnhtbExJQiBEaWdpRG9jNGovREVWIGZvcm1hdDogYXBwbGljYXRpb24vdm5kLmV0c2kuYXNpYy1lK3ppcCBzaWduYXR1cmVQcm9maWxlOiBYQWRFU19CQVNFTElORV9MVEEgSmF2YTogMS44LjBfMjAyLWVhL09yYWNsZSBDb3Jwb3JhdGlvbiBPUzogV2luZG93cyAxMC9hbWQ2NC8xMC4wIEpWTTogSmF2YSBIb3RTcG90KFRNKSA2NC1CaXQgU2VydmVyIFZNL09yYWNsZSBDb3Jwb3JhdGlvbi8yNS4yMDItYjAzUEsBAhQAFAAICAgAbl7jTulhn26WHAAA/z8AABgAAADjAAAAAAAAAAAAOgEAAE1FVEEtSU5GL3NpZ25hdHVyZXMwLnhtbExJQiBEaWdpRG9jNGovREVWIGZvcm1hdDogYXBwbGljYXRpb24vdm5kLmV0c2kuYXNpYy1lK3ppcCBzaWduYXR1cmVQcm9maWxlOiBYQWRFU19CQVNFTElORV9MVEEgSmF2YTogMS44LjBfMjAyLWVhL09yYWNsZSBDb3Jwb3JhdGlvbiBPUzogV2luZG93cyAxMC9hbWQ2NC8xMC4wIEpWTTogSmF2YSBIb3RTcG90KFRNKSA2NC1CaXQgU2VydmVyIFZNL09yYWNsZSBDb3Jwb3JhdGlvbi8yNS4yMDItYjAzUEsBAhQAFAAAAAgACV/jTrWudOecAAAArAAAAB0AAAAAAAAAAQAgAAAAFh4AAE1FVEEtSU5GL2hhc2hjb2Rlcy1zaGEyNTYueG1sUEsBAhQAFAAAAAgAE1/jTiZxYyK/AAAA2AAAAB0AAAAAAAAAAQAgAAAA7R4AAE1FVEEtSU5GL2hhc2hjb2Rlcy1zaGE1MTIueG1sUEsFBgAAAAAFAAUA/gMAAOcfAAAAAA==";

    // Signing mock strings
    public static final String SIGNER_CERT_PEM = "MIID6jCCA02gAwIBAgIQR+qcVFxYF1pcSy/QGEnMVjAKBggqhkjOPQQDBDBgMQswCQYDVQQGEwJFRTEbMBkGA1UECgwSU0sgSUQgU29sdXRpb25zIEFTMRcwFQYDVQRhDA5OVFJFRS0xMDc0NzAxMzEbMBkGA1UEAwwSVEVTVCBvZiBFU1RFSUQyMDE4MB4XDTE5MDEyNTE1NDgzMVoXDTI0MDEyNTIxNTk1OVowfzELMAkGA1UEBhMCRUUxKjAoBgNVBAMMIUrDlUVPUkcsSkFBSy1LUklTVEpBTiwzODAwMTA4NTcxODEQMA4GA1UEBAwHSsOVRU9SRzEWMBQGA1UEKgwNSkFBSy1LUklTVEpBTjEaMBgGA1UEBRMRUE5PRUUtMzgwMDEwODU3MTgwdjAQBgcqhkjOPQIBBgUrgQQAIgNiAATbyCq95SWCQTr+b5MXxRLTHYHJHCgaLornlrF9j+q6aFCDFLgoNv70yw/sHYp2FQ0yRywG2vFwDCLA5vACPLSVPGyOvYx7fiX84uSpPo6fcNlwQ25coNfpUIIuh+T6MwujggGrMIIBpzAJBgNVHRMEAjAAMA4GA1UdDwEB/wQEAwIGQDBIBgNVHSAEQTA/MDIGCysGAQQBg5EhAQIBMCMwIQYIKwYBBQUHAgEWFWh0dHBzOi8vd3d3LnNrLmVlL0NQUzAJBgcEAIvsQAECMB0GA1UdDgQWBBTIgEaf0wSPZSWihjLuyTNmzm4DWzCBigYIKwYBBQUHAQMEfjB8MAgGBgQAjkYBATAIBgYEAI5GAQQwEwYGBACORgEGMAkGBwQAjkYBBgEwUQYGBACORgEFMEcwRRY/aHR0cHM6Ly9zay5lZS9lbi9yZXBvc2l0b3J5L2NvbmRpdGlvbnMtZm9yLXVzZS1vZi1jZXJ0aWZpY2F0ZXMvEwJFTjAfBgNVHSMEGDAWgBTAhJkpxE6fOwI09pnhClYACCk+ezBzBggrBgEFBQcBAQRnMGUwLAYIKwYBBQUHMAGGIGh0dHA6Ly9haWEuZGVtby5zay5lZS9lc3RlaWQyMDE4MDUGCCsGAQUFBzAChilodHRwOi8vYy5zay5lZS9UZXN0X29mX0VTVEVJRDIwMTguZGVyLmNydDAKBggqhkjOPQQDBAOBigAwgYYCQSPBHYO2O/aLmr+vqMlESJrIY3gdtWni8hd4phIl5fR3uiQaQvtNeGBIzrGvdqgRJmYg+HvskQb/Laq7Xjp+cgqkAkEX9+x/S3H/S/+n/nogfgRSP5JCwYAw02zTRL3MKLpZ1AOf8i1iGvpHI9S6iyXcDhh6hM8slDg7EK3KyNwfkMLh5A==";

    // Response strings
    public static final String CONTAINER_ID = "containerId";
    public static final String CONTAINER = "container";
    public static final String CONTAINER_NAME = "containerName";
    public static final String RESULT = "result";
    public static final String DATA_TO_SIGN = "dataToSign";
    public static final String DIGEST_ALGO = "digestAlgorithm";
    public static final String MID_STATUS = "midStatus";
    public static final String SMARTID_STATUS = "sidStatus";
    public static final String GENERATED_SIGNATURE_ID = "generatedSignatureId";
    public static final String CHALLENGE_ID = "challengeId";

    // Validation response strings
    public static final String REPORT_VALID_SIGNATURES_COUNT = "validationConclusion.validSignaturesCount";
    public static final String REPORT_SIGNATURES_COUNT = "validationConclusion.signaturesCount";
    public static final String REPORT_SIGNATURES = "validationConclusion.signatures";

    // Error response strings
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MESSAGE = "errorMessage";

    // Error codes
    public static final String RESOURCE_NOT_FOUND = "RESOURCE_NOT_FOUND_EXCEPTION";
    public static final String INVALID_REQUEST = "REQUEST_VALIDATION_EXCEPTION";
    public static final String CLIENT_EXCEPTION = "CLIENT_EXCEPTION";
    public static final String SENDING_ERROR = "SENDING_ERROR";
    public static final String USER_CANCEL = "USER_CANCEL";
    public static final String NOT_VALID = "NOT_VALID";
    public static final String SIM_ERROR = "SIM_ERROR";
    public static final String PHONE_ABSENT = "PHONE_ABSENT";
    public static final String EXPIRED_TRANSACTION = "EXPIRED_TRANSACTION";
    public static final String INVALID_CONTAINER = "INVALID_CONTAINER_EXCEPTION";
    public static final String AUTHORIZATION_ERROR = "AUTHORIZATION_ERROR";
    public static final String INVALID_SIGNATURE = "SIGNATURE_CREATION_EXCEPTION";
    public static final String INVALID_LANGUAGE = "INVALID_LANGUAGE_EXCEPTION";
}
