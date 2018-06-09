Dan Needham

Thought Question:

Using an ordered vector instead of a trie would slow the process of searching for spelling suggestions. Searching for differences across one or more letters requires, in the worst case, iterating through the entire structure, as the incorrect word and the suggestion might differ by the first letter which would place them a large distance apart in the structure. Therefore the worst case for the ordered vector would be iterating through the n elements, so it would take O(n). The trie case would require traversing through the structure, across a constant number of children on log(n) levels,so it would take O(log(n)).  
