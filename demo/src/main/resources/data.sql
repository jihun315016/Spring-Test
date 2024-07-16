-- 공통 코드
INSERT INTO common_code (code_group, code, name, description) VALUES ('Aladin-ItemList', 'QueryType', 'ItemNewAll', '');
INSERT INTO common_code (code_group, code, name, description) VALUES ('Aladin-ItemList', 'MaxResults', '6', '');
INSERT INTO common_code (code_group, code, name, description) VALUES ('Aladin-ItemList', 'SearchTarget', 'Book', '');
INSERT INTO common_code (code_group, code, name, description) VALUES ('Aladin-ItemList', 'output', 'js', '');
INSERT INTO common_code (code_group, code, name, description) VALUES ('Aladin-ItemList', 'Version', '20131101', '');
INSERT INTO common_code (code_group, code, name, description) VALUES ('Aladin-ItemList', 'Cover', 'Big', '');


-- 메뉴
INSERT INTO menu (id, level, menu_name, path, parent_menu_id) VALUES (1, 1, 'first', '', 0);
INSERT INTO menu (id, level, menu_name, path, parent_menu_id) VALUES (2, 2, 'first_one', '/first_one', 1);
INSERT INTO menu (id, level, menu_name, path, parent_menu_id) VALUES (3, 2, 'first_two', '/first_two', 1);
INSERT INTO menu (id, level, menu_name, path, parent_menu_id) VALUES (4, 1, 'second', '', 0);
INSERT INTO menu (id, level, menu_name, path, parent_menu_id) VALUES (5, 2, 'second_one', '/second_one', 4);
