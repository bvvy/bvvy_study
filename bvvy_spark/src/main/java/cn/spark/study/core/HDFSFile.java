package cn.spark.study.core;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

/**
 * Created by bvvy on 2017/8/7.
 */
public class HDFSFile {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("HDFSFile");
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        JavaRDD<String> lines = sparkContext.textFile("hdfs://spark1:9000/spark.txt");
        JavaRDD<Integer> words = lines.map(new Function<String, Integer>() {
            public Integer call(String s) throws Exception {
                return s.length();
            }
        });

        int count = words.reduce(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });
        System.out.println("============================");
        System.out.println(count);

    }
}
