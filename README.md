ResolverSamples
=============================

BUILD

	mvn clean package
    
INSTALL
	
	./ConfigEngine.sh install-paa -DPAALocation=ResolverSamplePAA-0.0.1-SNAPSHOT-paa.zip
	./ConfigEngine.sh deploy-paa -DappName=com.ibm.portal.samples-ResolverSamplePAA
	
UNINSTALL

	./ConfigEngine.sh remove-paa -DappName=com.ibm.portal.samples-ResolverSamplePAA
	./ConfigEngine.sh uninstall-paa -DappName=com.ibm.portal.samples-ResolverSamplePAA
	./ConfigEngine.sh delete-paa -DappName=com.ibm.portal.samples-ResolverSamplePAA
		