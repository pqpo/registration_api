package cn.edu.hhu.reg.common.secutiry;

import java.util.Arrays;

public class MidFast64 {
    private final static char[] ALPHABET = {
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_', '-',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'
    };

    private final static int[] INV = new int[128];

    static {
        Arrays.fill(INV, -1);
        for(int i = 0; i < ALPHABET.length;i ++) {
            INV[ALPHABET[i]] = i;
        }
    }

    protected static String encode(int higI, int midI, int lowI) {
        if(higI == 0 && midI == 0 && lowI == 0) return "";
        char[] des = new char[16];
        des[0]  = ALPHABET[higI >>> 26 & 0x3f];
        des[1]  = ALPHABET[higI >>> 20 & 0x3f];
        des[2]  = ALPHABET[higI >>> 14 & 0x3f];
        des[3]  = ALPHABET[higI >>>  8 & 0x3f];
        des[4]  = ALPHABET[higI >>>  2 & 0x3f];
        des[5]  = ALPHABET[(higI & 0x3) | (midI >>> 26 & 0x3c)];
        des[6]  = ALPHABET[midI >>> 22 & 0x3f];
        des[7]  = ALPHABET[midI >>> 16 & 0x3f];
        des[8]  = ALPHABET[midI >>> 10 & 0x3f];
        des[9]  = ALPHABET[midI >>>  4 & 0x3f];
        des[10]  = ALPHABET[(midI & 0xf) | (lowI >>> 24 & 0x30)];
        des[11]  = ALPHABET[lowI >>> 24 & 0x3f];
        des[12]  = ALPHABET[lowI >>> 18 & 0x3f];
        des[13]  = ALPHABET[lowI >>> 12 & 0x3f];
        des[14] = ALPHABET[lowI >>>  6 & 0x3f];
        des[15] = ALPHABET[lowI        & 0x3f];
        return new String(des);
    }

    protected static int[] decode(String str) {
        if(str == null || str.length() != 16) return new int[]{0, 0, 0};
        char[] cs = str.toCharArray();
        if(!isValid(cs)) return new int[]{0, 0, 0};
        int[] des = new int[3];
        des[0] = INV[cs[0]] << 26 | INV[cs[1]] << 20 | INV[cs[2]] << 14 | INV[cs[3]] << 8 | INV[cs[4]] << 2;
        des[1] = INV[cs[6]] << 22 | INV[cs[7]] << 16 | INV[cs[8]] << 10 | INV[cs[9]] << 4;
        des[2] = INV[cs[11]] << 24 | INV[cs[12]] << 18 | INV[cs[13]] << 12 | INV[cs[14]] << 6 | INV[cs[15]];
        des[0] = des[0] | (INV[cs[5]] & 0x3);
        des[1] = des[1] | (INV[cs[5]] & 0x3c) << 26 | (INV[cs[10]] & 0xf);
        des[2] = des[2] | (INV[cs[10]] & 0x30) << 24;
        return des;
    }

    protected static boolean isValid(char[] cs) {
        for(char c : cs) {
            if(c > 127 || INV[c] < 0) return false;
        }
        return true;
    }
}
