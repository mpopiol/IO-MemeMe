-- =========================================
-- Create table template Windows Azure SQL Database 
-- =========================================

IF OBJECT_ID('dbo.MemeSet', 'U') IS NOT NULL
  DROP TABLE MemeSet
GO

CREATE TABLE [dbo].[MemeSet]
(
Id integer NOT NULL IDENTITY PRIMARY KEY,
Title varchar(max) NOT NULL,
Content varchar(max) NOT NULL,
ImgLink varchar(max) NULL,
Details varchar(max) DEFAULT('-brak dodatkowych informacji-'),
Author varchar(max) DEFAULT('Anonim'),
DateCreated datetime DEFAULT(getdate()), 
LastUpdate datetime DEFAULT(getdate())
)
GO

CREATE TRIGGER dbo.memeUpdateDate 
ON dbo.MemeSet
FOR UPDATE 
AS 
BEGIN 
    IF NOT UPDATE(LastUpdate) 
        UPDATE dbo.MemeSet SET LastUpdate=GETDATE() 
        WHERE id IN (SELECT id FROM inserted) 
END 
GO

