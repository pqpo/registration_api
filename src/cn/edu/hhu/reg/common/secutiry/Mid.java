package cn.edu.hhu.reg.common.secutiry;

public class Mid {
    private static int sPid;
    private static int sTime;
    private static int sInc;

    private final int higI;
    private final int midI;
    private final int lowI;

    static {
        sPid = java.lang.management.ManagementFactory.getRuntimeMXBean()
                .getName().hashCode();
    }

    public Mid(int h, int m, int l) {
        higI = h;
        midI = m;
        lowI = l;
    }

    public synchronized static String generator() {
        int time = (int) (System.currentTimeMillis() / 1000L);
        int mill = (int) (System.currentTimeMillis() % 10000);
        sInc ++;
        if(sTime != time) {
            sTime = time;
            sInc = 0;
        }
        int h = sTime;
        int m = (mill & 0xFF00) << 16 | (sInc & 0xFF) << 16
                | mill & 0xFF | (sInc & 0xFF00) << 8;
        int l = sPid & 0xFF00FFFF | sInc & 0xFF0000;
        return new Mid(h, m, l).toString();
    }

    public static Mid string(String id) {
        int[] is = MidFast64.decode(id);
        return new Mid(is[0], is[1], is[2]);
    }

    @Override
    public String toString() {
        return MidFast64.encode(higI, midI, lowI);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Mid) {
            Mid id = (Mid) o;
            return id.higI == higI && id.midI == midI && id.lowI == lowI;
        }
        return false;
    }

    public boolean isEmpty() {
        return higI == 0 && midI == 0 && lowI == 0;
    }

    public static boolean isEmpty(String id) {
        return Mid.string(id).isEmpty();
    }
}
