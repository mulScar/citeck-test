SELECT num + 1 as start_skip_interval, next_num - num - 1 as count_skip_numbers
FROM (SELECT num, LEAD(num) OVER(ORDER BY num) as next_num FROM NUMBERS) N
WHERE num + 1 <> next_num