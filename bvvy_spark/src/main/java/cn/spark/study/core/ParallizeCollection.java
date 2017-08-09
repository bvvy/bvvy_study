package cn.spark.study.core;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bvvy on 2017/8/7.
 */
public class ParallizeCollection {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("ParallizeCollection").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        JavaRDD<Integer> numbers = jsc.parallelize(nums);

        int sum = numbers.reduce(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });
        System.out.println(sum);
        jsc.close();
    }


}
