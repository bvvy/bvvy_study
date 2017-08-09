package cn.spark.study.core;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by bvvy on 2017/8/7.
 */
public class WordCountLocal {

    public static void main(String[] args) {
        //第一步 创建spark conf 配置应用信息
        SparkConf conf = new SparkConf()
                .setAppName("WordCountLocal")
                .setMaster("local");
        //第二步 创建JavaSparkContext 对象
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> lines = jsc.textFile("E:\\Mine\\ownProjects\\2017\\bvvy_study\\bvvy_spark\\src\\main\\resources\\spark.txt");
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            public Iterable<String> call(String line) throws Exception {
                return Arrays.asList(line.split(" "));
            }
        });
//创建RDD
        JavaPairRDD<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String word) throws Exception {
                return new Tuple2<String, Integer>(word,1);
            }
        });

        JavaPairRDD<String, Integer> wordCounts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });
        wordCounts.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            public void call(Tuple2<String, Integer> wordCount) throws Exception {
                System.out.println(wordCount._1 + " appeared " + wordCount._2 + " times");
            }
        });
        jsc.close();
    }
}
