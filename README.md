# Лаб 9: Код хамралт, JaCoCo

Д.Ууганбаяр, b232270004
F.CSA313 Программ хангамжийн чанарын баталгаа ба туршилт

## Орчин

```
$ java -version
openjdk version "17.0.16" 2025-07-15
OpenJDK Runtime Environment Homebrew (build 17.0.16+0)
OpenJDK 64-Bit Server VM Homebrew (build 17.0.16+0, mixed mode, sharing)
$ mvn -version
Apache Maven 3.9.14 (996c630dbc656c76214ce58821dcc58be960875b)
Maven home: /Users/uugnaa/.sdkman/candidates/maven/current
Java version: 17.0.16, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk@17/17.0.16/libexec/openjdk.jdk/Contents/Home
Default locale: en_MN, platform encoding: UTF-8
OS name: "mac os x", version: "26.5.2", arch: "aarch64", family: "mac"
```

JUnit 5.10.2, JaCoCo 0.8.12 (starter-ийн pom.xml). Starter дээр `mvn verify` ажиллуулахад `No tests to run.` ба `Skipping JaCoCo execution due to missing execution data file.` гарч, тайлан үүсээгүй.

## Хэсэг A: Happy path

[ScholarshipCalculatorTest.java](src/test/java/mn/edu/must/sqat/ScholarshipCalculatorTest.java)-д хэвийн урсгалын 5 тест: `letterGrade(95)="A"`, `letterGrade(85)="B"`, `gpa([95, 85])=3.5`, `scholarship(3.9, 16, false)=100`, `scholarship(3.5, 12, false)=70`.

```bash
mvn verify 2>&1 | tee results/mvn-verify-A.txt
cp target/site/jacoco/jacoco.csv results/jacoco-A.csv
```

[results/jacoco-A.csv](results/jacoco-A.csv): LINE_COVERED 15, LINE_MISSED 10, BRANCH_COVERED 20, BRANCH_MISSED 21.

- Line: 15 / 25 = 60%
- Branch: 20 / 41 = 48.8%

Шар мөрүүд нь нөхцөлийн зөвхөн нэг тал нь ажилласан газар: 52-р мөрийн `gpa >= 3.8 && credits >= 15`-д голч хүрсэн ч кредит дутуу тохиолдол байхгүй, 36-р мөрийн switch-д зөвхөн A, B case орж C, D, default ороогүй. Улаан мөрүүд нь гурван `throw` (21, 32, 49-р мөр) буюу алдааны зам бүгд, мөн C, D, F дүн, 50 ба 0 хувийн тэтгэлэг. Happy path тестүүд зөвхөн өндөр оноо, өндөр голчтой оролт өгсөн тул доод шатны салаа руу нэг ч тест ороогүй.
