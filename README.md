# Sample for Bean Validation on AWS Lambda

以下のような、コレクション要素への Validation が AWS Lambda 上で動作するかの確認用コード

```java
private List<@Min(5) @Max(10)> list;
```