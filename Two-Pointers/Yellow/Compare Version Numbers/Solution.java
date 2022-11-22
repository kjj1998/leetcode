class Solution {
    public int compareVersion(String version1, String version2) {
        
        int ver1Pointer = 0;
        int ver2Pointer = 0;
        int ver1Revision = 0;
        int ver2Revision = 0;
        int ver1Length = version1.length();
        int ver2Length = version2.length();

        while (ver1Pointer < ver1Length || ver2Pointer < ver2Length) {
            ver1Revision = 0;
            ver2Revision = 0;

            while (ver1Pointer < ver1Length && version1.charAt(ver1Pointer) != '.') {
                ver1Revision = ver1Revision*10 + version1.charAt(ver1Pointer++) - '0';
            }

            while (ver2Pointer < ver2Length && version2.charAt(ver2Pointer) != '.') {
                ver2Revision = ver2Revision*10 + version2.charAt(ver2Pointer++) - '0';
            }

            if (ver1Revision >  ver2Revision) {
                return 1;
            } else if (ver1Revision < ver2Revision) {
                return -1;
            } else {
                ver1Pointer++;
                ver2Pointer++;
            }
        }

        return 0;
    }
}