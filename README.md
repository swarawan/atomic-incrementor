# Atomic Incrementor

Steps to reproduce:
1. Execute Query
```
CREATE DATABASE 'todo_app';

-- todo_app.todo definition

CREATE TABLE 'todo' (
    'id' int NOT NULL AUTO_INCREMENT,
    'name' varchar(100) DEFAULT NULL,
    'description' varchar(100) DEFAULT NULL,
    'created_at' datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=3087 DEFAULT CHARSET=utf8;
```

2. To test concurrency, we can use JMeter.
```
Google and install it
```