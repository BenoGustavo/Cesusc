from pyspark.sql import SparkSession
from pathlib import Path
from pyspark.sql import functions as f
from pyspark.sql.types import DoubleType

spark: SparkSession = SparkSession.builder.appName(
    "Loading business data"
).getOrCreate()

BUSINESS_FOLDER = Path().resolve() / "data" / "empresas" / "empresas"
PARTNER_FOLDER = Path().resolve() / "data" / "socios" / "socios"
ESTABLISHMENT_FOLDER = (
    Path().resolve() / "data" / "estabelecimentos" / "estabelecimentos"
)


def load_business_data():
    business_col_names = [
        "cnpj_basico",
        "razao_social_nome_empresarial",
        "natureza_juridica",
        "qualificacao_do_responsavel",
        "capital_social_da_empresa",
        "porte_da_empresa",
        "ente_federativo_responsavel",
    ]
    business_df = spark.read.csv(str(BUSINESS_FOLDER), sep=";", inferSchema=True)

    # Adding header
    for index, column_name in enumerate(business_col_names):
        business_df = business_df.withColumnRenamed(f"_c{index}", column_name)

    # Converting capital_social_da_empresa to Double
    business_df = business_df.withColumn(
        "capital_social_da_empresa",
        f.regexp_replace(f.col("capital_social_da_empresa"), ",", "."),
    )

    # Converting capital_social_da_empresa to float
    business_df = business_df.withColumn(
        "capital_social_da_empresa",
        f.col("capital_social_da_empresa").cast(DoubleType()),
    )

    return business_df


def load_partner_data():
    partner_col_names = [
        "cnpj_basico",
        "identificador_de_socio",
        "nome_do_socio_ou_razao_social",
        "cnpj_ou_cpf_do_socio",
        "qualificacao_do_socio",
        "data_de_entrada_sociedade",
        "pais",
        "representante_legal",
        "nome_do_representante",
        "qualificacao_do_representante_legal",
        "faixa_etaria",
    ]
    partner_df = spark.read.csv(str(PARTNER_FOLDER), sep=";", inferSchema=True)

    # Adding header
    for index, column_name in enumerate(partner_col_names):
        partner_df = partner_df.withColumnRenamed(f"_c{index}", column_name)

    # Converting data_de_entrada_sociedade to date
    partner_df = partner_df.withColumn(
        "data_de_entrada_sociedade",
        f.to_date(f.col("data_de_entrada_sociedade"), "yyyyMMdd"),
    )

    return partner_df


def load_establishment_data():
    establishment_col_names = [
        "cnpj_basico",
        "cnpj_ordem",
        "cnpj_dv",
        "identificador_matriz_filial",
        "nome_fantasia",
        "situacao_cadastral",
        "data_situacao_cadastral",
        "motivo_situacao_cadastral",
        "nome_da_cidade_no_exterior",
        "pais",
        "data_de_inicio_atividade",
        "cnae_fiscal_principal",
        "cnae_fiscal_secundaria",
        "tipo_de_logradouro",
        "logradouro",
        "numero",
        "complemento",
        "bairro",
        "cep",
        "uf",
        "municipio",
        "ddd_1",
        "telefone_1",
        "ddd_2",
        "telefone_2",
        "ddd_do_fax",
        "fax",
        "correio_eletronico",
        "situacao_especial",
        "data_da_situacao_especial",
    ]
    establishment_df = spark.read.csv(
        str(ESTABLISHMENT_FOLDER), sep=";", inferSchema=True
    )

    # Adding header
    for index, column_name in enumerate(establishment_col_names):
        establishment_df = establishment_df.withColumnRenamed(f"_c{index}", column_name)

    # Converting data_de_inicio_atividade, data_situacao_cadastral and data_da_situacao_especial to DATE
    establishment_df = establishment_df.withColumn(
        "data_de_inicio_atividade",
        f.to_date(f.col("data_de_inicio_atividade"), "yyyyMMdd"),
    )

    establishment_df = establishment_df.withColumn(
        "data_situacao_cadastral",
        f.to_date(f.col("data_situacao_cadastral"), "yyyyMMdd"),
    )

    establishment_df = establishment_df.withColumn(
        "data_da_situacao_especial",
        f.to_date(f.col("data_da_situacao_especial"), "yyyyMMdd"),
    )

    return establishment_df


if __name__ == "__main__":
    print("\n\nBusiness data loaded:")
    print(load_business_data().show())
    print("Business data schema:")
    print(load_business_data().printSchema())

    print("\n\nPartner data loaded:")
    print(load_partner_data().show())
    print("Partner data schema:")
    print(load_partner_data().printSchema())

    print("\n\nEstablishment data loaded:")
    print(load_establishment_data().show())
    print("Establishment data schema:")
    print(load_establishment_data().printSchema())
