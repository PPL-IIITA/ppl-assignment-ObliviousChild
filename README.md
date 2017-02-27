# Principles of Programming Languages Assignment
## Object Oriented Programming  
### RIT2015074

### Contents
* [Build details](#build-details)
* [Deployment and Testing](#deployment-and-testing)
* [Documentation](https://ppl-iiita.github.io/ppl-assignment-faheemzunjani/Q1-2/docs/)
* [Class Diagrams](#class-diagrams)

#### Build Details
Developed and Tested on:
* Nestbeans Version: NetBeans IDE 8.1 (Build 201510222201)
* Java: 1.8.0_101; Java HotSpot(TM) 64-Bit Server VM 25.101-b13
* Runtime: Java(TM) SE Runtime Environment 1.8.0_101-b13
* System: Windows 8.1 version 6.3 running on amd64; Cp1252; en_US (nb)

#### Deployment and Testing
```
$ git clone https://github.com/PPL-IIITA/ppl-assignment-ObliviousChild
```

Change to directory:
```
$ cd ppl-assignment-ObliviousChild/PPLValentine/build/classes
```

For Q1:
```
$ java pplvalentine.Q1
```

For Q2:
```
$ java pplvalentine.Q2 <optional:value of k, default value is 5>
```

View log:
```
$ cat log.txt
```
Randomly generated gifts, girls and boys are provided in gifts.txt, girls.txt and boys.txt.
To randomly generate files again:
```
$ java pplvalentine.InputCreator
```

#### Details of randomly generated files:

##### Gifts.txt
* 60 gifts
* 20 of each type

##### Girls.txt
* 12 girls
* unique random string names
* 4 of each type

##### Boys.txt
* 50 boys
* unique random string names

#### Documentation

https://github.com/PPL-IIITA/ppl-assignment-ObliviousChild/tree/master/PPLValentine/dist/javadoc

#### Class Diagrams

https://github.com/PPL-IIITA/ppl-assignment-ObliviousChild/blob/master/PPLValentine/PPLValentineClassDiagram.png
