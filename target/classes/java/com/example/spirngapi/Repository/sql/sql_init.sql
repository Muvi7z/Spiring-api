-- create table product
-- (
--     id          bigserial
--         primary key,
--     name        varchar(200),
--     price       integer,
--     quantity    integer,
--     description varchar(400)
-- );
--
-- alter table product
--     owner to postgres;

select p from Product p where p.name like '%SSD M.2 накопитель%' and p.description like '%%' and p.price = 9999