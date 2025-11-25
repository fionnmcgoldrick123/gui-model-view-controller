DOP uses immutable data, meaning that once a record or value is created, it can’t be changed. 
This makes the code easier to reason about because data never changes behind your back. 
Bugs caused by accidental updates don’t happen, and the program becomes more predictable. 
It also works well with validation, because if the data is checked once in the constructor, 
you know it will stay valid.

The main drawback is that you sometimes need to create new copies of records when you want to 
“update” something. This can feel repetitive and create extra object allocations, especially 
when changing lists. But overall, the clarity and safety usually outweigh the small performance 
or convenience cost.