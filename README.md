# TechnicalTest - Problem 2

A . This example is done in Java using eclipse neon.

##### External Libraries
Google gson library used to de-serialized json into java object.

##### B. Test Suite for this Example



##### C. Possible problems with large data set.

There are two major factors that need to be consider for scaling large data set.
Memory and CPU usage (processing time)

##For memory:
In this problem, i have used object model to read and de-serialize json. This object model is easy to use but not good for large data set because 
it will load all the data in memory at once that will be required a lot of memory and parsing time.
One other thing is, for object model whole json file need to be loaded for parsing this will also cause memory and I/O bottlenecks.
Another technique called Streaming is best for parsing large json data set, but it is difficult manipulate objects.
This technique read file one token at a time so the memory overhead is minimal.
So, best solution would be mix of both object and streaming models, where file can be read in stream mode and just load a single object in memory at a time.

##For CPU Processing:

We can make our main process matrix method as multithreaded so that we can process multiple articles parallel. But in this case the matrix map should be immutable
If we blessed by distributed machines, mapreduce technique can be used to map a bunch of articles to each node and later reduce (combine) them to get final result.
