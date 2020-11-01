#A tuple is a collection which is ordered and unchangeable. In Python tuples are written with #round brackets.

#tuple
thistuple = ["apple", "banana", "cherry"]
print(thistuple)

#Access Items
thistuple = ["apple", "banana", "cherry"]
print(thistuple[1])

#Negative Indexing
thistuple = ["apple", "banana", "cherry"]
print(thistuple[-1])

#Range of Indexes
thistuple = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thistuple[2:5])

thistuple = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thistuple[:4])

thistuple = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thistuple[2:])

#Change Item Value
thistuple = ["apple", "banana", "cherry"]
thistuple[1] = "blackcurrant"
print(thistuple)

#Loop Through a tuple
thistuple = ["apple", "banana", "cherry"]
for x in thistuple:
  print(x) 

#Check if Item Exists
thistuple = ["apple", "banana", "cherry"]
if "apple" in thistuple:
  print("Yes, 'apple' is in the fruits tuple") 

#tuple Length
thistuple = ["apple", "banana", "cherry"]
print(len(thistuple)) 

#Add Items
thistuple = ["apple", "banana", "cherry"]
thistuple.append("orange")
print(thistuple)

thistuple = ["apple", "banana", "cherry"]
thistuple.insert(1, "orange")
print(thistuple)

#Remove Item
thistuple = ["apple", "banana", "cherry"]
thistuple.remove("banana")
print(thistuple)

thistuple = ["apple", "banana", "cherry"]
thistuple.pop()
print(thistuple)

thistuple = ["apple", "banana", "cherry"]
del thistuple[0]
print(thistuple)

thistuple = ["apple", "banana", "cherry"]
del thistuple 

thistuple = ["apple", "banana", "cherry"]
thistuple.clear()
print(thistuple)

thistuple = ["apple", "banana", "cherry"]
mytuple = thistuple.copy()
print(mytuple)

thistuple = ["apple", "banana", "cherry"]
mytuple = tuple(thistuple)
print(mytuple)

tuple1 = ["a", "b" , "c"]
tuple2 = [1, 2, 3]

tuple3 = tuple1 + tuple2
print(tuple3) 

tuple1 = ["a", "b" , "c"]
tuple2 = [1, 2, 3]

for x in tuple2:
  tuple1.append(x)

print(tuple1) 

tuple1 = ["a", "b" , "c"]
tuple2 = [1, 2, 3]

tuple1.extend(tuple2)
print(tuple1) 

thistuple = tuple(("apple", "banana", "cherry")) # note the double round-brackets
print(thistuple)