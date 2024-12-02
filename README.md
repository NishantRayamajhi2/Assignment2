# Assignment2
**Algorithm 3: Print Students with Total Marks Less Than Threshold**

Input: List of students with their total marks, threshold value
Output: List of students with total marks less than the threshold

1. Initialize an empty list called filteredStudents
2. For each student in the input list:
   a. If the student's total marks are less than the threshold:
      i. Add the student to the filteredStudents list
3. Print "Students with total marks less than [threshold]:"
4. For each student in the filteredStudents list:
   a. Print the student's details

**Algorithm 4: Print Top and Bottom 5 Students by Total Marks**

Input: List of students with their total marks
Output: Top 5 students with highest total marks and bottom 5 students with lowest total marks

1. Initialize an empty list called students
2. For each student in the input list:
   a. Add the student to the students list
3. Sort the students list in ascending order based on total marks
4. Initialize an empty list called top5
5. Initialize an empty list called bottom5
6. For i from 0 to 4:
   a. Add the student at index i from the students list to the bottom5 list
7. For i from length of students - 1 to length of students - 5:
   a. Add the student at index i from the students list to the top5 list
8. Print "Top 5 Students:"
9. For each student in the top5 list:
   a. Print the student's details
10. Print "Bottom 5 Students:"
11. For each student in the bottom5 list:
   a. Print the student's details
