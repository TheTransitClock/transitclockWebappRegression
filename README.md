This is a project to run a set of UI regression tests against the transiTime web interface.

It requires Selenium and the chrome driver installed on the local machine to run.

To run the tests  

```
mvn -DargLine="-Dbaseurl=http://127.0.0.1:8080/web" install
```

This will run the tests against a transiTime install at http://127.0.0.1:8080/web. You can change this to be any URL with transiTime installed to test it.