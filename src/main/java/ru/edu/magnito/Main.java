package ru.edu.magnito;

public class Main {
    public static void main(String[] args) {
        Algoritm algoritm = new Algoritm();

        Input test1 = test1();
        System.out.println(test1);
        algoritm.calc(test1);

        Input test2 = test2();
        System.out.println(test2);

        Input test3 = test3();
        System.out.println(test3);
        algoritm.calc(test3);
    }

    /**
     * **SSS*NM**
     * 10 42 68 = 492
     */
    private static Input test3() {
        int[] track = parseInputString("**SSS*NM**", 10);
        return new Input(track, track.length, 42, 68);
    }

    /**
     * ***S*S*M**N**********
     * 20 71 30 = 492
     */
    private static Input test2() {
        int[] recordingTrack = parseInputString("***S*S*M**N*********", 20);
        return new Input(recordingTrack, recordingTrack.length, 71, 30);
    }

    /**
     * S***N*M
     * 7 13 8 = 58 = 8*4(записи по 2) + 13*2(шаг)
     */
    private static Input test1() {
        int[] track = parseInputString("S***N*M", 7);
        return new Input(track, track.length, 13, 8);
    }

    private static int[] parseInputString(String strRecordData, int size) {
        validate(strRecordData, size);
        int[] recordingTrack = new int[size];
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

    private static void validate(String strRecordData, int size) {
        if (strRecordData.length() > size) {
            throw new IllegalArgumentException("not a record data");
        }
    }
}
