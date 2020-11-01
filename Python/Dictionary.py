thisdict =	{
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
print(thisdict)

#Accessing Items
x = thisdict["model"]

x = thisdict.get("model")

thisdict =	{
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
thisdict["year"] = 2018

#Loop Through a Dictionary
for x in thisdict:
  print(x) 