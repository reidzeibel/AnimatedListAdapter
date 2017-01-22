AnimatedListAdapter
===================

An android library that makes it easy to create an animated expand-collapse list using RecyclerView

Code was taken from [Nick Butcher's Plaid App](https://github.com/nickbutcher/plaid), I just separated the code into a BaseAnimatedListAdapter so it is easier to use.

Video from Google I/O 2016 : https://www.youtube.com/watch?v=EjTJIDKT72M (example of the animation starts at [5:24](https://youtu.be/EjTJIDKT72M?t=324))

*Requires API v19

Download
--------

Download latest [aar](https://dl.bintray.com/reidzeibel/maven/com/reidzeibel/animatedlistadapter/animated-list-adapter/0.3/:animated-list-adapter-0.3.aar), or grab via Maven:
```xml
<dependency>
  <groupId>com.reidzeibel.animatedlistadapter</groupId>
  <artifactId>animated-list-adapter</artifactId>
  <version>0.3</version>
  <type>pom</type>
</dependency>
```
or Gradle:
```groovy
compile 'com.reidzeibel.animatedlistadapter:animated-list-adapter:0.2'
```

Library is distributed via JCenter


Example Usage
-------------

Check the Sample App inside repo

**Result** : 

![](https://thumbs.gfycat.com/CrispDizzyGar-size_restricted.gif)

License
-------

    Copyright 2017 Ridwan Aditama (reidzeibel)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
