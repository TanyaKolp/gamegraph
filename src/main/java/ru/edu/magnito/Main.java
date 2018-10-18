package ru.edu.magnito;

public class Main {
    public static void main(String[] args) {

        test1();

        test2();

        test3();
    }

    /**
     * **SSS*NM**
     * 10 42 68 = 492
     */
    private static Input test3() {
        int[] track = parseInputString("**SSS*NM**");
        return new Input(track, track.length, 42, 68);
    }

    /**
     * ***S*S*M**N**********
     * 20 71 30 = 492
     */
    private static Input test2() {
        int[] recordingTrack = parseInputString("***S*S*M**N**********");
        return new Input(recordingTrack, recordingTrack.length, 71, 30);
    }

    /**
     * S***N*M
     * 7 13 8 = 58
     */
    private static Input test1() {
        int[] track = parseInputString("S***N*M");
        return new Input(track, track.length, 13, 8);
    }

    private static int[] parseInputString(String strRecordData) {
        validate(strRecordData);
        int[] recordingTrack = new int[strRecordData.length()];
        char[] chars = strRecordData.toCharArray();
        for (int i = 0; i < strRecordData.length(); i++) {
            if ('S' == chars[i]) {
                recordingTrack[i] = 1;
            }
            if ('M' == chars[i]) {
                recordingTrack[i] = 2;
            }
            if ('N' == chars[i]) {
                recordingTrack[i] = 3;
            }
        }
        return recordingTrack;
    }

    private static void validate(String strRecordData) {
        if (false) {
            throw new IllegalArgumentException("not a record data");
        }
    }
}
