INSERT INTO rota (nome, origem, destino, distancia)
VALUES
('sp-rj', 'sao paulo', 'rio de janeiro', 437),
('rj-sp', 'rio de janeiro', 'sao paulo', 437),
('sp-bh', 'sao paulo', 'belo horizonte', 586),
('bh-sp', 'belo horizonte', 'sao paulo', 586),
('sp-df', 'sao paulo', 'brasilia', 1018),
('df-sp', 'brasilia', 'sao paulo', 1018),
('sp-slv', 'sao paulo', 'salvador', 1657),
('slv-sp', 'salvador', 'sao paulo', 1657),
('sp-fn', 'sao paulo', 'fortaleza', 2830),
('fn-sp', 'fortaleza', 'sao paulo', 2830),
('rj-bh', 'rio de janeiro', 'belo horizonte', 434),
('bh-rj', 'belo horizonte', 'rio de janeiro', 434),
('rj-df', 'rio de janeiro', 'brasilia', 1148),
('df-rj', 'brasilia', 'rio de janeiro', 1148),
('rj-slv', 'rio de janeiro', 'salvador', 1558),
('slv-rj','salvador','rio de janeiro' ,1558),
('rj-fn','rio de janeiro','fortaleza' ,2774),
('fn-rj','fortaleza','rio de janeiro' ,2774),
('bh-df','belo horizonte','brasilia' ,719),
('df-bh','brasilia','belo horizonte' ,719),
('bh-slv','belo horizonte','salvador' ,1381),
('slv-bh','salvador','belo horizonte' ,1381),
('bh-fn','belo horizonte','fortaleza' ,2595),
('fn-bh','fortaleza','belo horizonte' ,2595),
('df-slv','brasilia','salvador' ,1164),
('slv-df','salvador','brasilia' ,1164),
('df-fn','brasilia','fortaleza' ,2379),
('fn-df','fortaleza','brasilia' ,2379),
('slv-fn','salvador','fortaleza' ,1626),
('fn-slv','fortaleza','salvador' ,1626),
('sp-rp','sao paulo','ribeirao preto' ,313),
('rp-sp','ribeirao preto','sao paulo' ,313),
('sp-cps','sao paulo','campinas' ,94),
('cps-sp','campinas','sao paulo' ,94),
('rj-cps','rio de janeiro','campinas' ,499),
('cps-rj', 'campinas', 'rio de janeiro', 499),
('rj-rp', 'rio de janeiro', 'ribeirao preto', 714),
('rp-rj', 'ribeirao preto', 'rio de janeiro', 714),
('bh-cps', 'belo horizonte', 'campinas', 586),
('cps-bh', 'campinas', 'belo horizonte', 586),
('bh-rp', 'belo horizonte', 'ribeirao preto', 523),
('rp-bh', 'ribeirao preto', 'belo horizonte', 523),
('df-cps', 'brasilia', 'campinas', 1021),
('cps-df', 'campinas', 'brasilia', 1021),
('df-rp', 'brasilia', 'ribeirao preto', 932),
('rp-df','ribeirao preto','brasilia' ,932),
('slv-cps','salvador','campinas' ,1464),
('cps-slv','campinas','salvador' ,1464),
('slv-rp','salvador','ribeirao preto' ,1668),
('rp-slv','ribeirao preto','salvador' ,1668);

INSERT INTO aeronave (aeronave, id, prefixo, velocidade, autonomia, empresa, n_passageiros, peso_max, companhia)
VALUES
('particular', 0, 'PTABA', 800, 2500, 'MEC1', NULL, NULL, NULL),
('particular', 1, 'PTACA', 800, 2500, 'MEC2', NULL, NULL, NULL),
('passageiros', 2, 'PPADA', 1200, 5000, NULL, 200, NULL, 'GOL'),
('passageiros', 3,'PPAEA' ,1200 ,5000 ,NULL ,200 ,NULL ,'AZUL'),
('carga',4 ,'PUXKZ' ,900 ,8000 ,NULL ,NULL ,100000 ,'EVERGREEN'),
('carga',5 ,'PUXLZ' ,900 ,8000 ,NULL ,NULL ,100000 ,'EVERGREEN');