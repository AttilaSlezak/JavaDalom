# JavaDalom
Music manager application

About the task:

mp3 search: as a user I want to be able to search in a given file list which contains only mp3 files. I want to define custom search criteria which may contain any of the ID3 tag properties and/or the name of the file.
Acceptance criteria:
system waits for a list of mp3 files which should be a prepared file list
system asks the search keyword
system asks which property should be used in the search process
if there is no keyword and any criteria the full list should be the result
by default all ID3 property and the filename is in the search process
if any concrete property or properties choosed the search should go only these fields
system logs out the result file list to the console
system logs out the count of results in this form:
count: {count_of_result_list}
