set project_root=d:\Mentoring\REPO\JMP_D2_2016_Churakou_Sushchanka\module17SOAPClient\
cd %project_root%/src/main/java/
wsimport -Xnocompile -verbose http://localhost:8080/module17?wsdl
cd %project_root%