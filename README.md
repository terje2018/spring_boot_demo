# spring_boot_demo
使用spring4中成熟的spring boot技术,配合docker/k8s构建符合native cloud的基础demo.使用spring 管理mybatis,便于使用.

## maven
clean package

## docker image build:
cd spring_boot_demo <br/>
docker build -t spring_boot_demo:0.1 .

## k8s deploy:
kubectl apply -f deploy.yml <br/>
kubectl apply -f svc.yml
