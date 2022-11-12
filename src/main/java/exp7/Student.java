package exp7;

import java.util.Arrays;

import static exp7.Sort.InsertSort;

public class Student {
    public int averageScore;
    public String number;

    Student(int averageScore,String number){
        this.averageScore=averageScore;
        this.number=number;
    }
    Student(){
        this.averageScore=0;
        this.number="";
    }



    public static Student[] BucketSort(Student[] sourceArray) {
        Student[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0].averageScore;
        int maxValue = arr[0].averageScore;
        for (Student value : arr) {
            if (value.averageScore < minValue) {
                minValue = value.averageScore;
            } else if (value.averageScore > maxValue) {
                maxValue = value.averageScore;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / 5) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (Student student : arr) {
            int index = (int) Math.floor((student.averageScore - minValue) / 5);
            buckets[index] = BucketAppend(buckets[index], student.averageScore);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = InsertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++].averageScore = value;
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] BucketAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1]= value;
        return arr;
    }


}
