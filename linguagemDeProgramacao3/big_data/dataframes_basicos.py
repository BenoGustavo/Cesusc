from pyspark.sql import SparkSession

spark: SparkSession = SparkSession.builder.appName(
    "Creating a new dataframe"
).getOrCreate()

data = [("Zeca", "35"), ("Eva", "29")]
colNames = ["Nome", "Idade"]


df = spark.createDataFrame(data, colNames)

print(df.show())
