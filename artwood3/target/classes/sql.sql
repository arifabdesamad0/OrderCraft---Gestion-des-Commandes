drop database artwood;
create database if not exists artwood;

use artwwod;
CREATE TABLE `orders` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `client_id` int DEFAULT NULL,
                          `date` date DEFAULT NULL,
                          `status` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `client_id` (`client_id`),

)
create table if not exists users
CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(255) NOT NULL,
                         `password` varchar(255) NOT NULL,
                         `email` varchar(255) NOT NULL,
                         PRIMARY KEY (`id`)
)


create table if not exists clients
(
    CREATE TABLE `clients` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) DEFAULT NULL,
    )
    create table if not exists items
    CREATE TABLE IF NOT EXISTS items (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
    );

    INSERT INTO items (name, description, price, quantity) VALUES
('Wooden Vase', 'Handcrafted wooden vase with intricate carvings', 20.00, 15),
('Oak Table', 'Solid oak dining table with a natural finish', 150.00, 10),
('Maple Chair', 'Ergonomic chair made from maple wood', 75.00, 20),
('Birch Bookshelf', 'Tall bookshelf crafted from birch with a polished surface', 120.00, 5),
('Cedar Jewelry Box', 'Small jewelry box made from cedar with velvet lining', 35.00, 25);



-- INSERT INTO user (user_id, user_name, user_email, user_role, user_password)
-- VALUES ('user1', 'Ahmed', 'ahmed@email.com', 'USER', 'password1'),
--        ('user2', 'Fatima', 'fatima@email.com', 'USER', 'password2'),
--        ('user3', 'Mehdi', 'mehdi@email.com', 'USER', 'password3'),
--        ('user4', 'Amina', 'amina@email.com', 'USER', 'password4'),
--        ('user5', 'Karim', 'karim@email.com', 'USER', 'password5'),
--        ('user6', 'Nadia', 'nadia@email.com', 'USER', 'password6'),
--        ('user7', 'Hassan', 'hassan@email.com', 'USER', 'password7'),
--        ('admin1', 'Sara', 'sara@email.com', 'ADMIN', 'admin_password');
-- INSERT INTO category (id_category, name_category)
-- VALUES ('0c5a7','Work'),
--        ('86411','Personal'),
--        ('40ef8','Shopping'),
--        ('eceb1','Health'),
--        ('cdeaf','Education'),
--        ('02e45','Entertainment');
--
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (1, 'task1', 'Complete Project Report', 'Finish the report for the upcoming meeting', '2023-12-13 21:44:46', 'haute', '0c5a7', 'user1');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (6, 'task6', 'Prepare Presentation', 'Get ready for the upcoming client presentation', '2023-12-13 21:44:46', 'haute', '0c5a7', 'user6');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (8, 'task8', 'Code Review', 'Review and provide feedback on team members\' code', '2023-12-13 21:44:46', 'moyenne', '0c5a7', 'user1');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (13, 'task13', 'Write Blog Post', 'Create a blog post on a relevant topic', '2023-12-13 21:44:46', 'moyenne', '0c5a7', 'user6');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (3, 'task3', 'Buy Groceries', 'Purchase items for the week', '2023-12-13 21:44:46', 'basse', '40ef8', 'user3');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (5, 'task5', 'Movie Night', 'Watch a movie with friends', '2023-12-13 21:44:46', 'basse', '02e45', 'user5');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (15, 'task15', 'Movie Marathon', 'Have a movie marathon at home', '2023-12-13 21:44:46', 'basse', '02e45', 'user1');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (7, 'task7', 'Read a Book', 'Spend some time reading a good book', '2023-12-13 21:44:46', 'basse', '86411', 'user7');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (9, 'task9', 'Cook Dinner', 'Prepare a delicious dinner for the family', '2023-12-13 21:44:46', 'basse', '86411', 'user2');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (12, 'task12', 'Plan Weekend Trip', 'Organize a short weekend getaway with friends', '2023-12-13 21:44:46', 'haute', '86411', 'user5');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (4, 'task4', 'Study Java Stream API', 'Learn and practice Java Stream API concepts', '2023-12-13 21:44:46', 'moyenne', 'cdeaf', 'user4');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (11, 'task11', 'Online Course', 'Enroll in an online course to enhance skills', '2023-12-13 21:44:46', 'moyenne', 'cdeaf', 'user4');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (2, 'task2', 'Gym Session', 'Hit the gym for a workout', '2023-12-13 21:44:46', 'moyenne', 'eceb1', 'user2');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (10, 'task10', 'Yoga Session', 'Practice yoga for relaxation', '2023-12-13 21:44:46', 'moyenne', 'eceb1', 'user3');
-- INSERT INTO `task` (`id`, `task_id`, `name`, `description`, `date_creation`, `priority`, `ref_category`, `ref_user`) VALUES (14, 'task14', 'Visit Doctor', 'Schedule and visit the doctor for a health checkup', '2023-12-13 21:44:46', 'haute', 'eceb1', 'user7');
-- SELECT * FROM task LEFT JOIN category ON task.ref_category = category.id_category;
-- UPDATE category SET name_category='HEllo' WHERE id_category='ae18c';
-- INSERT INTO user (user_id, user_name, user_email, user_role, user_password) VALUES ('cad37', 'Ahmed', 'ahmed@example.com', 'ADMIN', 'password1');
-- SELECT * from task LEFT JOIN category ON task.ref_category = category.id_category where task_id ='0b925';
-- <<<<<<< HEAD
-- SELECT history_id, task_id, action_change, time_modification, user.user_id,user.user_name FROM task_action_history LEFT JOIN user ON task_action_history.user_id = user.user_id;
-- select  user_id,user_name,user_email from user ;
-- =======
-- SELECT history_id, ta,sk_id, action_change,ref_category, time_modification user.user_name FROM task LEFT JOIN user ON task_action_history.user_id = user.user_id;
-- SELECT task_id,name,description,date_creation,priority,ref_category,ref_user , category.name_category,user.user_name FROM task LEFT JOIN user ON task.ref_user = user.user_id join category on task.ref_category = category.id_category;
-- >>>>>>> fixExp
