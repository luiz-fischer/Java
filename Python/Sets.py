#LIST
thisset = ["apple", "banana", "cherry"]
print(thisset)

#Access Items
thisset = ["apple", "banana", "cherry"]
print(thisset[1])

#Negative Indexing
thisset = ["apple", "banana", "cherry"]
print(thisset[-1])

#Range of Indexes
thisset = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thisset[2:5])

thisset = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thisset[:4])

thisset = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thisset[2:])

#Change Item Value
thisset = ["apple", "banana", "cherry"]
thisset[1] = "blackcurrant"
print(thisset)

#Loop Through a set
thisset = ["apple", "banana", "cherry"]
for x in thisset:
  print(x) 

#Check if Item Exists
thisset = ["apple", "banana", "cherry"]
if "apple" in thisset:
  print("Yes, 'apple' is in the fruits set") 

#set Length
thisset = ["apple", "banana", "cherry"]
print(len(thisset)) 

#Add Items
thisset = ["apple", "banana", "cherry"]
thisset.append("orange")
print(thisset)

thisset = ["apple", "banana", "cherry"]
thisset.insert(1, "orange")
print(thisset)

#Remove Item
thisset = ["apple", "banana", "cherry"]
thisset.remove("banana")
print(thisset)

thisset = ["apple", "banana", "cherry"]
thisset.pop()
print(thisset)

thisset = ["apple", "banana", "cherry"]
del thisset[0]
print(thisset)

thisset = ["apple", "banana", "cherry"]
del thisset 

thisset = ["apple", "banana", "cherry"]
thisset.clear()
print(thisset)

thisset = ["apple", "banana", "cherry"]
myset = thisset.copy()
print(myset)

thisset = ["apple", "banana", "cherry"]
myset = set(thisset)
print(myset)

set1 = ["a", "b" , "c"]
set2 = [1, 2, 3]

set3 = set1 + set2
print(set3) 

set1 = ["a", "b" , "c"]
set2 = [1, 2, 3]

for x in set2:
  set1.append(x)

print(set1) 

set1 = ["a", "b" , "c"]
set2 = [1, 2, 3]

set1.extend(set2)
print(set1) 

thisset = set(("apple", "banana", "cherry")) # note the double round-brackets
print(thisset)