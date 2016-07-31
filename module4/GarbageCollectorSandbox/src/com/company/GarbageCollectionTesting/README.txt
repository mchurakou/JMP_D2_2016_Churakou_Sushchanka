1) Serial Collector with the following parameters
the 6m initial heap size for when the JVM starts
the18m maximum heap size
the2m size of the Young Generation
the 20m starting size of the Permanent Generation
the 30 maximum size of the Permanent Generation

Cycle 50000:
c:\artifacts\JMP_D2_2016_Churakou_Sushchanka_jar>java -XX:+UseSerialGC -Xms6m -Xmx18m -Xmn2m -XX:MetaspaceSize=20m -XX:MaxMe
taspaceSize=30m -jar JMP_D2_2016_Churakou_Sushchanka.jar
Start time:1469986814729
Exception in thread "main" Exception in thread "RMI TCP Connection(idle)" Exception in thread "RMI TCP Connection(idle)" jav
a.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.util.ArrayList.grow(Unknown Source)
        at java.util.ArrayList.ensureExplicitCapacity(Unknown Source)
        at java.util.ArrayList.ensureCapacityInternal(Unknown Source)
        at java.util.ArrayList.add(Unknown Source)
        at com.company.GarbageCollectionTesting.Runner.main(Runner.java:17)
java.lang.OutOfMemoryError: Java heap space
java.lang.OutOfMemoryError: Java heap space

Cycle 5000:
c:\artifacts\JMP_D2_2016_Churakou_Sushchanka_jar>java -XX:+UseSerialGC -Xms6m -Xmx18m -Xmn2m -XX:MetaspaceSize=20m -XX:MaxMe
taspaceSize=30m -jar JMP_D2_2016_Churakou_Sushchanka.jar
Start time:1469987173894
5000
Map is filled with ArrayLists.
Nulling.
5000 arrayLists was nulled.
GC called
Finish time:1469987225827
Please, see screen: SerialGC_VisualGC.png and SerialGC_Monitor.png

2)  Parallel Collector with the following parameters
the 3m initial heap size for when the JVM starts
the12m maximum heap size
the1m size of the Young Generation
the 20m starting size of the Permanent Generation
the 20 maximum size of the Permanent Generation


Cycle 3000
c:\artifacts\JMP_D2_2016_Churakou_Sushchanka_jar>java -XX:+UseParallelGC -Xms3m -Xmx12m -Xmn1m -XX:MetaspaceSize=20m -XX:Max
MetaspaceSize=20m -jar JMP_D2_2016_Churakou_Sushchanka.jar
Java HotSpot(TM) 64-Bit Server VM warning: NewSize (1536k) is greater than the MaxNewSize (1024k). A new max generation size
 of 1536k will be used.
Start time:1469988948401
3000
Map is filled with ArrayLists.
Nulling.
3000 arrayLists was nulled.
GC called
Finish time:1469989249909
Please, see screenshots: ParallelGC_VisualGC.png and ParallerGC_Monitor.png

3) 3) Parallel Old Collector with the following parameters
the 9m initial heap size for when the JVM starts
the18m maximum heap size
the3m size of the Young Generation
the 40m starting size of the Permanent Generation
the 40 maximum size of the Permanent Generation

c:\artifacts\JMP_D2_2016_Churakou_Sushchanka_jar>java -XX:+UseParallelOldGC -Xms9m -Xmx18m -Xmn3m -XX:MetaspaceSize=40m -XX:
MaxMetaspaceSize=40m -jar JMP_D2_2016_Churakou_Sushchanka.jar
Start time:1469989531707
3000
Map is filled with ArrayLists.
Nulling.
3000 arrayLists was nulled.
GC called
Finish time:1469989833073
Please, see screenshots: ParallelGC_VisualGC.png and ParallerGC_Monitor.png

4) Concurrent Mark Sweep (C) Collector  with 2 Parallel CMS Threads  with the following parameters

the 6m initial heap size for when the JVM starts
the18m maximum heap size
the 2m size of the Young Generation
the 20m starting size of the Permanent Generation
the 30 maximum size of the Permanent Generatio

c:\artifacts\JMP_D2_2016_Churakou_Sushchanka_jar>java -XX:+UseConcMarkSweepGC -XX:ConcGCThreads=2 -Xms6m -Xmx18m -Xmn2m -XX:
MetaspaceSize=20m -XX:MaxMetaspaceSize=30m -jar JMP_D2_2016_Churakou_Sushchanka.jar
Start time:1469990596450
3000
Map is filled with ArrayLists.
Nulling.
3000 arrayLists was nulled.
GC called
Finish time:1469990897844
Please, see screenshots: CMS2Threads_VisualGC.png and CMS2Threads_Monitor.png

5) G1 Garbage Collector with the following parameters
the 4m initial heap size for when the JVM starts
the16m maximum heap size
them 2m size of the Young Generation
the 12m starting size of the Permanent Generation
the 18 maximum size of the Permanent Generation

c:\artifacts\JMP_D2_2016_Churakou_Sushchanka_jar>java -XX:+UseG1GC -Xms4m -Xmx16m -Xmn2m -XX:MetaspaceSize=12m -XX:MaxMetasp
aceSize=18m -jar JMP_D2_2016_Churakou_Sushchanka.jar
Start time:1469991151965
3000
Map is filled with ArrayLists.
Nulling.
3000 arrayLists was nulled.
GC called
Finish time:1469991453287
Please, see screenshots: G1GC_VisualGC.png and G1GC_Monitor.png


