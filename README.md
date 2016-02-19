# JavaDalom
Music manager application

Application for searching MP3

This application is able to search in a given file list which contains only mp3 files. The user can define custom search criteria which may contain any of the ID3 tag properties and/or the name of the file.

Parameters:
- system waits for a list of mp3 files which should be a prepared file list
- system asks the search keyword
- system asks which property should be used in the search process
- if there is no keyword and any criteria the full list is the result
- by default all ID3 property and the filename is in the search process
- if any concrete property or properties choosed the search should go only these fields
- system logs out the result file list to the console
- system logs out the count of results in this form:
count: {count_of_result_list}