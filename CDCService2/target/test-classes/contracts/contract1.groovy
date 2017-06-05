package contracts
import org.springframework.cloud.contract.spec.Contract

Contract.make {
   request {
       method 'GET'
       url '/testModelObjects'
   }
   response {
       status 200
       body("""
       {
	     "_embedded" : {
    	 "testModelObjects": [
      {
        "prop1": "prop1 value1",
        "prop2": "prop2 value1"
      },
      {
        "prop1": "prop1 value2",
        "prop2": "prop2 value2"
      },
      {
        "prop1": "prop1 value3",
        "prop2": "prop2 value3"
      },
      {
        "prop1": "prop1 value4",
        "prop2": "prop2 value4"
      },
      {
        "prop1": "prop1 value5",
        "prop2": "prop2 value5"
      },
      {
        "prop1": "prop1 value6",
        "prop2": "prop2 value6"
      }
    ]
  }
         }
         """)
       headers {
           header('Content-Type': value(
                   producer(regex('application/json.*')),
                   consumer('application/json')
           ))
       }
   }
}