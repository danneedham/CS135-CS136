1) The if statements disappear because we can just set the references as we need to, instead of having to consider different cases for what those references may need to be. 

2) Because indexOf actually returns the index, while contains returns a boolean.

3) The nodes that are passed to remove are already in the list, therefore they already have a location. For insertAfter, we need to give the node a location, which means we need to develop a way to set that location. This task is where the two methods (before or after) arise.

4) The special cases for add are when we are adding the first and last elements to the list. This is desirable because we don't have to walk through the whole list in these cases. 

5) The original file was bigger than the result source. 
