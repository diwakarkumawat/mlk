
insert into User(email, first_name, last_name) values('diwakar@mlk.com', 'Diwakar', 'Kumaawat');
insert into User(email, first_name, last_name) values('diwakar1@mlk.com', 'Diwakar1', 'Kumawat');

# Prepopulate CharityGoal with values such as “Feed the hungry”, “Protect animals”, “Save the Children”, “Rescue those in trouble”, “Save the planet”, “Medical research”
insert into charity_goal(name, date_created, date_updated) values ('Feed the hungry', now(), now());
insert into charity_goal(name, date_created, date_updated) values ('Protect animals', now(), now());
insert into charity_goal(name, date_created, date_updated) values ('Save the Children', now(), now());
insert into charity_goal(name, date_created, date_updated) values ('Rescue those in trouble', now(), now());
insert into charity_goal(name, date_created, date_updated) values ('Save the planet', now(), now());
insert into charity_goal(name, date_created, date_updated) values ('Medical research', now(), now());

# Prepopulate Charity with values such as “ASPCA”, “RedCross”, “American Cancer Society”
insert into charity(name, date_created, date_updated) values('ASPCA', now(), now());
insert into charity(name, date_created, date_updated) values('RedCross', now(), now());
insert into charity(name, date_created, date_updated) values('American Cancer Society', now(), now());

# Prepopulate Donor with values such as “Jack” “Jones”, “John” “Smith”, “Helen” “Smith”, and “Sally” “Underhill”.
insert into donor(email, first_name, last_name, date_created, date_updated) values('Jack@fun.com', 'Jack', 'Jones', now(), now());
insert into donor(email, first_name, last_name, date_created, date_updated) values('John@fun.com', 'John', 'Smith', now(), now());
insert into donor(email, first_name, last_name, date_created, date_updated) values('Helen@fun.com', 'Helen', 'Smith', now(), now());
insert into donor(email, first_name, last_name, date_created, date_updated) values('Sally@fun.com', 'Sally', 'Underhill', now(), now());

