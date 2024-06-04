INSERT INTO questions (id, description, technology) VALUES
('6d51504a-d4bc-4f83-bc3a-beb41b962c09', 'Como criar uma classe em Java?', 'JAVA'),
('d780e9b8-f587-43ca-b8ab-93d9c3f0e8a6', 'Explique o conceito de polomorfismo em Java', 'JAVA'),
('35d0339d-b54c-4899-99f1-b75304992fe2', 'Como lidar com exceções em Java?', 'JAVA');

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('596419b3-1fd5-47a0-a82d-ed703ff6d90d', '6d51504a-d4bc-4f83-bc3a-beb41b962c09', true, 'Usando a palavra-chave "class"'),
('91106233-0d8a-4482-be4d-d2cc22883ead', '6d51504a-d4bc-4f83-bc3a-beb41b962c09', false, 'Definindo um interface em Java'),
('b80bfdfa-1ad2-40e5-b7dd-292e3d047861', '6d51504a-d4bc-4f83-bc3a-beb41b962c09', false, 'Utilizando métodos estáticos'),
('5492e1b2-b9e0-4fa5-a7e2-a5f78e40df12', '6d51504a-d4bc-4f83-bc3a-beb41b962c09', false, 'Criando um construtor padrão');

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('65a18e1d-6070-4f47-9c6e-c18a10d43fc2', 'd780e9b8-f587-43ca-b8ab-93d9c3f0e8a6', false, 'Herança simples'),
('d13f4d84-55dd-4fc7-a792-51f3a7a21cc6', 'd780e9b8-f587-43ca-b8ab-93d9c3f0e8a6', false, 'Encapsulamento em Java'),
('180a1c31-ea91-457a-9c18-c305a63684ae', 'd780e9b8-f587-43ca-b8ab-93d9c3f0e8a6', false, 'Sobrecarga de métodos'),
('fa1dd231-a2cb-448d-b32a-1ba837f7a772', 'd780e9b8-f587-43ca-b8ab-93d9c3f0e8a6', true, 'Capacidade de um objeto de assumir várias formas');

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('696e5e2e-84a3-4fa2-9b87-45ecc518d4fc', '35d0339d-b54c-4899-99f1-b75304992fe2', false, 'Ignorando a exceção'),
('9829111e-baa4-46f7-854a-7af9fc664b9b', '35d0339d-b54c-4899-99f1-b75304992fe2', true, 'Utilizando blocos try-catch'),
('eeb514fb-89d6-4a96-9f7e-c8f8deb868ac', '35d0339d-b54c-4899-99f1-b75304992fe2', false, 'Declarando uma exceção sem tratamento'),
('b220102f-a517-483a-921a-bfac0b1c0423', '35d0339d-b54c-4899-99f1-b75304992fe2', false, 'Usando a palavra-chave "finally"');
