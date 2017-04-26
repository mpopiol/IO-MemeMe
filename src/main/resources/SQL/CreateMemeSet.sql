-- =========================================
-- Create table template Windows Azure SQL Database 
-- =========================================

IF OBJECT_ID('dbo.MemeSet', 'U') IS NOT NULL
  DROP TABLE MemeSet
GO

CREATE TABLE [dbo].[MemeSet]
(
Id integer NOT NULL PRIMARY KEY,
Title varchar(max) NOT NULL,
Content varchar(max) NOT NULL,
ImgLink varchar(max) NOT NULL,
Author varchar(max) NULL,
DateCreated datetime NULL,
LastUpdate datetime NULL
)
GO
