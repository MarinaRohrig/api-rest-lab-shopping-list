INSERT INTO public.category(description, name) VALUES ('Refrigerantes gelados', 'Refrigerante');
INSERT INTO public.category(description, name) VALUES ('Sorvete 2L', 'Sorvetes');
INSERT INTO public.category(description, name) VALUES ('Bomboniere', 'Amendoim');

INSERT INTO public.product(buyed, name, price, id_category) VALUES ( true,'Coca-cola' ,8 ,1);
INSERT INTO public.product(buyed, name, price, id_category) VALUES ( false,'Flocos' ,10.4 ,2);
INSERT INTO public.product(buyed, name, price, id_category) VALUES ( true,'Amendoim sabor do chefe' ,10.4,null);