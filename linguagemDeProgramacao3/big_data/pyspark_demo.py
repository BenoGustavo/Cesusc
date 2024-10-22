# Import necessary libraries
from pyspark.sql import SparkSession

# Create a Spark session
spark = SparkSession.builder.appName("PySpark Word Count Example").getOrCreate()

# Create an RDD (Resilient Distributed Dataset) from a list of sentences
data = [
    "Hello world",
    "Hello Spark",
    "This is a simple PySpark test",
    "PySpark is fun",
    "Hello again",
]

# Parallelize the data (convert it into an RDD)
rdd = spark.sparkContext.parallelize(data)

# Split each sentence into words
words_rdd = rdd.flatMap(lambda line: line.split(" "))

# Map each word to a (word, 1) pair
word_pairs_rdd = words_rdd.map(lambda word: (word, 1))

# Reduce by key to count the occurrences of each word
word_count_rdd = word_pairs_rdd.reduceByKey(lambda a, b: a + b)

# Collect the results and print them
for word, count in word_count_rdd.collect():
    print(f"{word}: {count}")

# Stop the Spark session
spark.stop()
