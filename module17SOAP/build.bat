set project_root=d:\Mentoring\REPO\JMP_D2_2016_Churakou_Sushchanka\module17SOAP\
cd %project_root%/src/main/java/
wsgen -verbose -cp %project_root%/target/classes -Xnocompile com.company.sushchanka.service.UserServiceImpl
cd %project_root%