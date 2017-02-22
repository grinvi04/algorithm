package util;

import java.text.DecimalFormat;

/**
 * Created by ikgb76 on 2017-02-22.
 */
public class MemoryTest {
    static Runtime r = Runtime.getRuntime();
    static int mb = 1024 * 1024; // MByte

    public static void main(String[] args) {
        showMemory();
    }

    public static void showMemory() {
        DecimalFormat format = new DecimalFormat("###,###,###.##");

        //JVM이 현재 시스템에 요구 가능한 최대 메모리량, 이 값을 넘으면 OutOfMemory 오류가 발생 합니다.
        long max = r.maxMemory();

        //JVM이 현재 시스템에 얻어 쓴 메모리의 총량
        long total = r.totalMemory();

        //JVM이 현재 시스템에 청구하여 사용중인 최대 메모리(total)중에서 사용 가능한 메모리
        long free = r.freeMemory();

        System.out.println("Max:" + format.format(max/mb) + ", Total:" + format.format(total/mb) + ", Free:"+format.format(free/mb));
        System.out.println("Used:" + format.format((total-free)/mb));
    }
}
