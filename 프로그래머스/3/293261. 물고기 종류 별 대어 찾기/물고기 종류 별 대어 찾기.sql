SELECT fi.id, fni.fish_name, fi.length
FROM fish_info fi
INNER JOIN (
    SELECT fish_type, MAX(length) AS max_length 
    FROM fish_info 
    GROUP BY fish_type
) leng 
ON fi.fish_type = leng.fish_type AND fi.length = leng.max_length
INNER JOIN fish_name_info fni 
ON fni.fish_type = fi.fish_type
order by fi.id asc
;
