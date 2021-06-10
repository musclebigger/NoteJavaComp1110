###### **why using hashing**

1. pruning a search: -looking for duplicate; - looking for similar values

2. Compression: compact that the key

3. correctness: checksums can confirm inequality 

例子： credit card 16位数字 是一个checksums（校验和）--Luhn Algorithm

例子2：加密MD5，hashing很难被逆转

###### **Hash table**

two approaches：separate chaining（list作为一部分）; open addressing（遍历table找空的没有空添加）,解决hash table的size问题