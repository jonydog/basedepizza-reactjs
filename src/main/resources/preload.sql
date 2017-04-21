DROP TABLE dbo.por_order_pizzas;
DROP TABLE dbo.por_pizza_ingredients;
DROP TABLE dbo.por_order;
DROP TABLE dbo.por_user;
DROP TABLE dbo.por_pizza;
DROP TABLE dbo.por_ingredient;


CREATE TABLE [dbo].[por_ingredient](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[isVegetarian] [bit] NOT NULL,
	[name] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[por_pizza](
	[iD] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[description] [varchar](255) NULL,
	[isVegetarian] [bit] NOT NULL,
	[name] [varchar](50) NOT NULL,
	[priceInEuros] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[iD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[por_user](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[phone] [varchar](255) NULL,
	[username] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[por_order](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[finished] [bit] NOT NULL,
	[orderStartingDate] [datetime] NOT NULL,
	[price] [float] NOT NULL,
	[orderownerId] [numeric](19, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[por_pizza_ingredients](
	[pizzaId] [numeric](19, 0) NOT NULL,
	[ingredientsId] [numeric](19, 0) NOT NULL
) ON [PRIMARY]

CREATE TABLE [dbo].[por_order_pizzas](
	[orderId] [numeric](19, 0) NOT NULL,
	[pizzasId] [numeric](19, 0) NOT NULL
) ON [PRIMARY]


INSERT INTO dbo.por_user VALUES ('Fernando', 'fernando@sapo.pt', '919218131', 'passFernando');
INSERT INTO dbo.por_user VALUES ('Pedro', 'pedro@sapo.pt', '916724718', 'passPedro');
INSERT INTO dbo.por_user VALUES ('Joao', 'joao@sapo.pt', '92814141', 'passJoao');
INSERT INTO dbo.por_user VALUES ('Tiago', 'tiago@sapo.pt', '92814141', 'passTiago');
INSERT INTO dbo.por_user VALUES ('Daniel', 'daniel@sapo.pt', '98351751', 'passDaniel');
INSERT INTO dbo.por_user VALUES ('Bruno', 'bruno@sapo.pt', '98148111', 'passBruno');
INSERT INTO dbo.por_user VALUES ('Joana', 'joana@sapo.pt', '91941941', 'passJoana');

INSERT INTO dbo.por_ingredient VALUES (0, 'pepperoni');
INSERT INTO dbo.por_ingredient VALUES (1, 'cogumelos');
INSERT INTO dbo.por_ingredient VALUES (0, 'fiambre');
INSERT INTO dbo.por_ingredient VALUES (1, 'queijo');
INSERT INTO dbo.por_ingredient VALUES (0, 'bacon');
INSERT INTO dbo.por_ingredient VALUES (0, 'atum');
INSERT INTO dbo.por_ingredient VALUES (1, 'azeitonas');

INSERT INTO dbo.por_pizza VALUES ('muita boa', 0, 'Americana', 9.0);
INSERT INTO dbo.por_pizza VALUES ('Veg', 1, 'Hawaina',8.0);
INSERT INTO dbo.por_pizza VALUES ('Veg tambem', 1,'Funghi', 7.0);
INSERT INTO dbo.por_pizza VALUES ('Peixe', 0, 'Mar', 11.0);
INSERT INTO dbo.por_pizza VALUES ('Pizza da casa', 0, 'Casa', 9.0);
INSERT INTO dbo.por_pizza VALUES ('Veg tambem', 1, 'Veg', 5.5);

INSERT INTO dbo.por_order VALUES (0, '2017-04-07', 14.5, 1);
INSERT INTO dbo.por_order VALUES (0, '2017-04-04', 8.0, 2);
INSERT INTO dbo.por_order VALUES (0, '2017-03-27', 18.0, 3);
INSERT INTO dbo.por_order VALUES (0, '2017-02-25', 11.0, 4);
INSERT INTO dbo.por_order VALUES (0, '2017-04-06', 12.5, 3);

INSERT INTO dbo.por_pizza_ingredients VALUES (1, 1);
INSERT INTO dbo.por_pizza_ingredients VALUES (1,5);
INSERT INTO dbo.por_pizza_ingredients VALUES (2,7);
INSERT INTO dbo.por_pizza_ingredients VALUES (2,4);
INSERT INTO dbo.por_pizza_ingredients VALUES (3,2);
INSERT INTO dbo.por_pizza_ingredients VALUES (4,6);
INSERT INTO dbo.por_pizza_ingredients VALUES (5,3);
INSERT INTO dbo.por_pizza_ingredients VALUES (5,5);
INSERT INTO dbo.por_pizza_ingredients VALUES (6,4);
INSERT INTO dbo.por_pizza_ingredients VALUES (6,2);

INSERT INTO dbo.por_order_pizzas VALUES (1, 1);
INSERT INTO dbo.por_order_pizzas VALUES (1, 6);
INSERT INTO dbo.por_order_pizzas VALUES (2, 2);
INSERT INTO dbo.por_order_pizzas VALUES (3, 3);
INSERT INTO dbo.por_order_pizzas VALUES (3, 4);
INSERT INTO dbo.por_order_pizzas VALUES (4, 4);
INSERT INTO dbo.por_order_pizzas VALUES (5, 3);
INSERT INTO dbo.por_order_pizzas VALUES (5, 6);






