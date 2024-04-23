import { Stack, Box, Breadcrumb, BreadcrumbItem, BreadcrumbLink, Heading, Icon, Text  } from "@chakra-ui/react";
import React from "react";
import { ChevronRightIcon } from "@chakra-ui/icons";
import {FaHome} from 'react-icons/fa';
function News(){
    return(
        <Stack minH='640px' color='white' bgColor='#1F1D36'  px={120} py={18}>
              <Box>
                <Breadcrumb spacing='8px' separator={<Text fontSize={'32px'}><ChevronRightIcon /></Text>}>
                    <BreadcrumbItem  >
                        <BreadcrumbLink >
                            <Icon pt='6px' as={FaHome}  fontSize='32px' />
                        </BreadcrumbLink>
                    </BreadcrumbItem>
                    <BreadcrumbItem>
                        <BreadcrumbLink ><Heading fontSize='24px'>Tin mới</Heading></BreadcrumbLink>
                    </BreadcrumbItem>
                </Breadcrumb>
                <hr/>
                <Heading>Hiện tại không có tin mới</Heading>
                </Box>
        </Stack>
    )
}

export default News