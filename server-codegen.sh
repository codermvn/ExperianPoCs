#!/bin/bash

set -x
set -e

"C:\\Program Files\\Java\\jdk1.8.0_241\\bin\\java" -Xmx1024M -cp "lib/swagger-codegen-cli-3.0.15.jar" io.swagger.codegen.v3.cli.SwaggerCodegen generate -i api/customer-product-order.yml -c server-codegen-config.json -o customer-order-product-api-web -l spring --library spring-boot