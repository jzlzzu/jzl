LOAD DATA LOCAL INFILE 'sql.csv' IGNORE INTO TABLE `ceshi1550036319896` FIELDS TERMINATED BY '`' OPTIONALLY ENCLOSED BY '^' ESCAPED BY '\\' LINES TERMINATED BY '
' (
	@vid ,@vdate ,@vdouble ,@vname ,@vfloat ,@vlong ,@vtimestamp
)
SET `id` = nullif(@vid ,\ N),
 `date` = nullif(@vdate ,\ N),
 `double` = nullif(@vdouble ,\ N),
 `name` = nullif(@vname ,\ N),
 `float` = nullif(@vfloat ,\ N),
 `long` = nullif(@vlong ,\ N),
 `timestamp` = nullif(@vtimestamp ,\ N)
